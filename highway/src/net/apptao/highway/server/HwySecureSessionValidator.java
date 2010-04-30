package net.apptao.highway.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HwySecureSessionValidator {
	boolean isValid(String clienSessionId, String requestSessionId);
}
