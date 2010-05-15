package net.apptao.highway.server.auth

scenario "authenticate when already authenticated: attaching another identity from the same provider",{
	given "the user is already authenticated with one identity provider",{
	}
	
	and "the user wants to attach another identity to himself", {
	}
	
	and "that identity does not alread belong to another user", {
		
	}	
	
	when "the user is trying to authenticate with another identity from the same provider", {
	}
	
	then "that provider-given identity is attached to the user"
}

scenario "authenticate when already authenticated: attaching another identity from a different provider",{
	given "the user is already authenticated with one identity provider",{
	}
	
	and "the user wants to attach another identity from a different provider to himself", {
	}
	
	and "that identity does not already belong to another user", {
	}
	
	when "the user attempts to authenticate", {
	}
	
	then "that provider-given identity is attached to the user"
}

scenario "authenticate when already authenticated: attempting to attach an already taken identity", {
	given "the user is already authenticated with one identity provider",{
		
	}
	
	and "the user wants to attach another identity to himself", {
		
	}
	
	and "that identity is already taken by another user of the application", {
	}
	
	when "the user attemps to authenticate", {
		
	}
	
	then "an error is returned denying authentication for that identity to that user"
}


scenario "authenticate when already authenticated: with same identity",{
	given "the user is already authenticated with one identity provider",{
	}
	
	when "the user is trying to authenticate with that same identity again", {
	}
		
	then "nothing happens this is a no-op"
}