package net.apptao.highway.client.dispatch;

import net.apptao.highway.client.HwyClientCache;
import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyResult;
import net.customware.gwt.dispatch.client.AbstractDispatchAsync;
import net.customware.gwt.dispatch.client.ExceptionHandler;
import net.customware.gwt.dispatch.client.secure.SecureDispatchService;
import net.customware.gwt.dispatch.client.secure.SecureDispatchServiceAsync;
import net.customware.gwt.dispatch.client.secure.SecureSessionAccessor;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;
import net.customware.gwt.dispatch.shared.secure.InvalidSessionException;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.inject.Inject;

public class RichDispatchAsync extends AbstractDispatchAsync {

	private static final SecureDispatchServiceAsync realService = GWT.create( SecureDispatchService.class );
	private static final String baseUrl = ((ServiceDefTarget)realService).getServiceEntryPoint() + "/";


    private final SecureSessionAccessor secureSessionAccessor;
	private HwyClientCache cache;

	@Inject
	public RichDispatchAsync(ExceptionHandler exceptionHandler, 
			SecureSessionAccessor secureSessionAccessor, HwyClientCache cache) {
		super(exceptionHandler);
		this.secureSessionAccessor = secureSessionAccessor;
		this.cache = cache;
	}
	
    public <A extends Action<R>, R extends Result> void execute( final A action, 
    		final AsyncCallback<R> callback ) {
    	final boolean isCachedCommand = action instanceof HwyCachedCommand<?>;
    	if(isCachedCommand){
			HwyResult result = cache.get((HwyCommand<HwyResult>)action);
			if(result != null){
				// command cache hit! return immediately 
				RichDispatchAsync.this.onSuccess(action, (R) result, callback);
			}
		} else {
			// normal call
    	
	    	// Append action class name as extra path info
	        String className = action.getClass().getName();
	        int namePos = className.lastIndexOf(".") + 1;
	        className = className.substring(namePos);
	        ((ServiceDefTarget)realService).setServiceEntryPoint(baseUrl + className);
	        
	        String sessionId = secureSessionAccessor.getSessionId();
	
	        realService.execute( sessionId, action, new AsyncCallback<Result>() {
	            public void onFailure( Throwable caught ) {
	            	RichDispatchAsync.this.onFailure( action, caught, callback );
	            }
	
	            @SuppressWarnings({"unchecked"})
	            public void onSuccess( Result result ) {
	            	// cache the result if need be
	            	if(isCachedCommand){
	            		cache.put((HwyCommand<HwyResult>)action, (HwyResult) result, 
	            				((HwyCachedCommand)action).secondsUntilExpire());
	            	}
	            	RichDispatchAsync.this.onSuccess( action, (R) result, callback );
	            	
	            }
	        } );
		}
    }

    protected <A extends Action<R>, R extends Result> void onFailure( A action, Throwable caught, final AsyncCallback<R> callback ) {
        if ( caught instanceof InvalidSessionException ) {
            secureSessionAccessor.clearSessionId();
        }

        super.onFailure( action, caught, callback );

    }
}
