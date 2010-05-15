package net.apptao.highway.server.auth;

public interface HwyIdentityProvider {
	boolean exists();
	boolean authenticate();
}
