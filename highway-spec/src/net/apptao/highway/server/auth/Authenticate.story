package net.apptao.highway.server.auth

scenario "authenticate when not authenticated: identity exists in the user store", {
	given "the user is not authenticated",{
	}
	
	and "the identity he is trying to authenticate with already exists in the user store", {
		
	}
	
	when "the existing user attempts to authenticate", {
	}
	
	and "the auth dance succeeds", {
		
	}
	
	then "he is authenticated", {
	}
}

scenario "authenticate when not authenticated: identity does not exists in the user store", {
	given "the user is not authenticated",{
	}
	
	and "the identity he is trying to authenticate with does not exists in the user store"
	
	when "the new user attempts to authenticate (i.e, signup or registration)", {
	}	

	and "the auth dance succeeds", {
		
	}	
	
	then "he is added to the user store and associated with that identity", {
	}
}

scenario "authenticate with unfederated/immediate provider: single step authentication dance", {
	given "the user is not authenticated",{
	}
	
	and "the chosen identity provider can return login status immediately", {
		
	}
	
	and "the user credentials are valid for that provider", {
		
	}
	
	when "the user attempts to authenticate", {
		
	}
	
	then "he is authenticated", {
		
	}	
}

scenario "authenticate with federated provider: authentication dance step 1 - discovery and redirect to provider", {
	given "the user is not authenticated",{
	}
	
	and "the chosen identity provider can't return login status immediately", {
		
	}
	
	and "the federated provider is in REDIRECT mode", {
		
	}
	
	when "the user attempts to authenticate", {
		
	}
	
	then "the response redirects the user to the federated login page", {
		
	}	
	
	and "the federated provider is given the authValidation url (/hwy/auth ?)"
}

scenario "authenticate with federated provider: authentication dance step 1 - discovery and popup to provider", {
	given "the user is not authenticated",{
	}
	
	and "the chosen identity provider can't return login status immediately", {
		
	}
	
	and "the federated provider is in POPUP mode", {
		
	}
	
	when "the user attempts to authenticate", {
		
	}
	
	then "the response opens a popup for the user that points to the federated login page", {
		
	}	
	
	and "the federated provider is given the auth validation url (/hwy/auth ?)"
}

scenario "authenticate with federated provider: authentication dance step 2 - negative identity provider response", {
	given "the identity provider did not authenticate the user (negative auth response)", {
		
	}
	
	when "the auth validation url is hit", {
	}
	
	then "the user is redirected to the main app page unauthenticated", {
		
	}
}


scenario "authenticate with federated provider: authentication dance step 2 - validate upon positive identity provider response", {
	given "the identity provider authenticated the user a (positive auth response)", {
		
	}
	
	when "the auth validation url is hit", {
	}
	
	then "the auth info is validated with the provider if need be", {
		
	}
}

scenario "authenticate with federated provider: authentication dance step 2 - validated upon positive identity provider response", {
	given "auth info can be validated", {
		
	}
	
	when "the auth validation url is hit", {
	}
	
	then "the user is added to the session", {
		
	}
	
	and "the user's current provider-identity pair is also stored in the session", {
		
	}
	
	and "further call to the authentication check will return a positive result"
}

scenario "authenticate with federated provider: authentication dance step 2 - can't validate upon positive identity provider response", {
	given "auth info can't be validated", {
		
	}
	
	when "the auth validation url is hit", {
	}
	
	then "the user is redirected unauthenticated to the main app page", {
		
	}
}
