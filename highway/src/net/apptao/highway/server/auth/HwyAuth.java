package net.apptao.highway.server.auth;

import com.google.inject.Inject;

public class HwyAuth {
	
	private final HwyUserService hwyUserService;

	@Inject
	HwyAuth(HwyUserService hwyUserService) {
		this.hwyUserService = hwyUserService;
	}

	
}
