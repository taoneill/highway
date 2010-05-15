package net.apptao.highway.server.auth

scenario "authentication check on server when already authenticated", {
	given "the session is empty / the user is not already authenticated", {
	}
	
	when "we check for the authentication state", {
	}
	
	then "the returned value is false", {
	}
}

scenario "authentication check on server when not authenticated", {
	given "the hwy sessionId is in the session", {
	}
	
	and "and the user is stored in the session ", {
		
	}
	
	when "we check for the authentication state", {
	}
	
	then "the returned value is true", {
	}
}