package net.apptao.highway.client.auth


scenario "auto-checking on the client for authentication of a new visitor",{
	given "the user has never visited the site/has cleared his cookies",{
	}
	
	when "the user lands on the main app page ", {
	}
	
	then "a command is sent to the server to get the user info", {
	}
	
	and "the user comes back as not authenticated", {
		
	}
	// maybe from the client it could already be determined that, since
	// no cookies are there, then no on is authenticated
}