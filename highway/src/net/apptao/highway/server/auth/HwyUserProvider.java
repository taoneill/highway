package net.apptao.highway.server.auth;

public interface HwyUserProvider {
	Boolean isLoggedIn();
	Object get(String propertyName);
	String getCurrentUserKey();
}
