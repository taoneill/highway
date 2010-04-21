package net.apptao.highway.server;

import net.apptao.highway.shared.dispatch.HwyCommand;
import net.customware.gwt.dispatch.client.secure.SecureDispatchService;
import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.ActionException;
import net.customware.gwt.dispatch.shared.Result;
import net.customware.gwt.dispatch.shared.ServiceException;
import net.customware.gwt.dispatch.shared.secure.InvalidSessionException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class HwyAbstractDispatchServlet extends RemoteServiceServlet implements SecureDispatchService{

	@Override
	public Result execute(String sessionId, Action<?> action) throws ActionException, ServiceException {
		try {
			if (action instanceof HwyCommand<?> 
				&& getCommandRightsValidator().isUnsecured((HwyCommand<?>)action)){
				// If the command is not secured, let the call go through without session id verification
				return getDispatch().execute(action);
			} else if (getSessionValidator().isValid(sessionId, getThreadLocalRequest())) {
                return getDispatch().execute(action);
            } else {
                throw new InvalidSessionException();
            }
        } catch ( RuntimeException e ) {
            log("Exception while executing " + action.getClass().getName() + ": " + e.getMessage(), e);
            throw new ServiceException(e.getMessage());
        }
	}
	
	protected abstract HwyCommandRightsValidator getCommandRightsValidator();

    protected abstract SecureSessionValidator getSessionValidator();

    protected abstract Dispatch getDispatch();

}
