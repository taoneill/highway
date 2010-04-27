package net.apptao.highway.server.guice;

import net.apptao.highway.server.Highway;
import net.apptao.highway.server.HighwayServerImpl;
import net.apptao.highway.server.HwyDispatchServlet;
import net.apptao.highway.server.dispatch.HwyCommandRightsValidator;
import net.apptao.highway.server.dispatch.HwyCommandRightsValidatorImpl;
import net.customware.gwt.dispatch.server.appengine.AppEngineSecureSessionValidator;
import net.customware.gwt.dispatch.server.guice.GuiceDispatch;
import net.customware.gwt.dispatch.server.guice.GuiceLazyActionHandlerRegistry;
import net.customware.gwt.dispatch.server.guice.ServerDispatchModule;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;

import com.google.inject.servlet.ServletModule;

public class HighwayServletModule extends ServletModule {

	@Override
    protected void configureServlets() {
    	install(new ServerDispatchModule(GuiceDispatch.class, GuiceLazyActionHandlerRegistry.class));
    	bind(SecureSessionValidator.class).to(AppEngineSecureSessionValidator.class);
    	bind(HwyCommandRightsValidator.class).to(HwyCommandRightsValidatorImpl.class);
    	serveRegex("(.)*/dispatch/(.)*").with(HwyDispatchServlet.class);
    	bind(Highway.class).to(HighwayServerImpl.class);
    }
}
