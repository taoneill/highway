package net.apptao.highway.server.auth;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.objectify.ObjectifyService;

public class HwyUserService {

	Map<String, HwyUserProvider> providers = new HashMap<String, HwyUserProvider>();
	
	public HwyUser getCurrentUser() {
		HwyUser user = null;
		for(String providerName : providers.keySet()) {
			String userKey = providers.get(providerName).getCurrentUserKey();
			if(userKey != null) {
				user = ObjectifyService.begin().query(HwyUser.class)
						.filter("provider", providerName).filter("providerUserKey", userKey).get();
				if(user == null) {
					user = new HwyUser(providerName, userKey);	// Bad because now hwyuser doesnt really exist until committed
					// must be able to distinguish between authenticated and registered states
					break;
				}
			}
		}
		return user;
	}

}
