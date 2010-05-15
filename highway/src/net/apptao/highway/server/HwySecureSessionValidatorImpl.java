package net.apptao.highway.server;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Validates the client session id using a our own
 * cookie.
 * 
 * Full credit to David Peterson and David Chandler
 * since this is based on their AppEngineSecureSessionValidator
 * from gwt-dispatch which used the default AppEngine cookie
 * that changed name from GAE 1.3.3. 
 * 
 */
public class HwySecureSessionValidatorImpl implements HwySecureSessionValidator {


	
	@Override
	public boolean isValid(String clientSessionId, String requestSessionId) {
		
		User user = UserServiceFactory.getUserService().getCurrentUser();
		if ( user != null ) {
			// User is logged in, now try to match session tokens
			// to prevent CSRF
			if ( requestSessionId.equals(clientSessionId) ) {
			    return true;
		    }
		}
		return false;
	}

}
