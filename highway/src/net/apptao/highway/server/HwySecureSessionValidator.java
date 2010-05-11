package net.apptao.highway.server;

public interface HwySecureSessionValidator {
	boolean isValid(String clienSessionId, String requestSessionId);
}
