package net.apptao.highway.server.guice;

import net.apptao.highway.server.Highway;
import net.apptao.highway.server.HighwayServerImpl;
import net.apptao.highway.server.HwyDispatchServlet;
import net.apptao.highway.server.HwySecureSessionValidator;
import net.apptao.highway.server.HwySecureSessionValidatorImpl;
import net.apptao.highway.server.auth.HwyUser;
import net.apptao.highway.server.dispatch.HwyCommandRightsValidator;
import net.apptao.highway.server.dispatch.HwyCommandRightsValidatorImpl;
import net.customware.gwt.dispatch.server.guice.GuiceDispatch;
import net.customware.gwt.dispatch.server.guice.GuiceLazyActionHandlerRegistry;
import net.customware.gwt.dispatch.server.guice.ServerDispatchModule;

import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyService;

public class HighwayServletModule extends ServletModule {

	@Override
    protected void configureServlets() {
    	install(new ServerDispatchModule(GuiceDispatch.class, GuiceLazyActionHandlerRegistry.class));
    	bind(HwySecureSessionValidator.class).to(HwySecureSessionValidatorImpl.class);
    	bind(HwyCommandRightsValidator.class).to(HwyCommandRightsValidatorImpl.class);
    	serveRegex("(.)*/hwy/(.)*").with(HwyDispatchServlet.class);
    	bind(Highway.class).to(HighwayServerImpl.class);
    	ObjectifyService.register(HwyUser.class);
    }
}
