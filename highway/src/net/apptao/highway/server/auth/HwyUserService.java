package net.apptao.highway.server.auth;

import java.util.HashMap;
import java.util.Map;

public class HwyUserService {

	Map<String, HwyIdentityProvider> providers = new HashMap<String, HwyIdentityProvider>();
	
	public boolean isAuthenticated() {
		// check in session 
		return false;
	}
	
	public boolean isInRole(String role) {
		return false;
	}
	
	public void authenticate(String providerName) {
		provider(providerName);
	}
	
	public void validateAuthentication() {
		// at */hwy/auth/, use this
	}
	
	public HwyIdentityProvider provider(String providerName) {
		//use to authenticate
		return null;
	}
	
//	public HwyUser getCurrentUser() {
//		HwyUser user = null;
//		for(String providerName : providers.keySet()) {
//			String userKey = providers.get(providerName).getCurrentUserKey();
//			if(userKey != null) {
//				user = ObjectifyService.begin().query(HwyUser.class)
//						.filter("provider", providerName).filter("providerUserKey", userKey).get();
//				if(user == null) {
//					user = new HwyUser(providerName, userKey);	// Bad because now hwyuser doesnt really exist until committed
//					// must be able to distinguish between authenticated and registered states
//					break;
//				}
//			}
//		}
//		return user;
//	}

}
