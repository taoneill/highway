package net.apptao.highway.server;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.apptao.highway.client.dispatch.HwySecureDispatchService;
import net.apptao.highway.server.dispatch.HwyCommandRightsValidator;
import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.ActionException;
import net.customware.gwt.dispatch.shared.Result;
import net.customware.gwt.dispatch.shared.ServiceException;
import net.customware.gwt.dispatch.shared.secure.InvalidSessionException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class HwyAbstractDispatchServlet extends RemoteServiceServlet implements HwySecureDispatchService{
	
	private final static String COOKIENAME = "HWYSID";
	
	@Override
	public Result execute(Action<?> action, String clientSessionId) throws ActionException, ServiceException {
		try {
			HttpServletRequest request = getThreadLocalRequest();
			HttpServletResponse response = getThreadLocalResponse();
			String sessionId = getOrSetCookie(request, response);
			
			if (getCommandRightsValidator().isUnsecured(action)){
				// If the command is not secured, let the call go through without session id verification
				return getDispatch().execute(action);
			} else if (getSessionValidator().isValid(clientSessionId, sessionId)) {
                return getDispatch().execute(action);
            } else {
                throw new InvalidSessionException();
            }
        } catch ( RuntimeException e ) {
            log("Exception while executing " + action.getClass().getName() + ": " + e.getMessage(), e);
            throw new ServiceException(e.getMessage());
        }
	}
	
	private String getOrSetCookie(HttpServletRequest request, HttpServletResponse response) {
		String sessionId = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
			    if (cookie.getName().equals(COOKIENAME)) {
			        sessionId = cookie.getValue();
			        break;
			    }
			}
		}
		if (cookies == null || sessionId == ""){
			sessionId = String.valueOf(UUID.randomUUID());
			Cookie c = new Cookie(COOKIENAME, "");
			c.setValue(sessionId);
			c.setMaxAge(-1);
			c.setPath("/");
			response.addCookie(c);
		}		
		return sessionId;
	}

	protected abstract HwyCommandRightsValidator getCommandRightsValidator();

    protected abstract HwySecureSessionValidator getSessionValidator();

    protected abstract Dispatch getDispatch();

}
