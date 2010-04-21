package net.apptao.highway.server.guice;

import net.apptao.highway.server.Highway;
import net.apptao.highway.server.HighwayServerImpl;
import net.apptao.highway.server.HwyCommandRightsValidator;
import net.apptao.highway.server.HwyCommandRightsValidatorImpl;
import net.apptao.highway.server.HwyDaoService;
import net.apptao.highway.server.HwyDispatchServlet;
import net.customware.gwt.dispatch.server.appengine.AppEngineSecureSessionValidator;
import net.customware.gwt.dispatch.server.guice.GuiceDispatch;
import net.customware.gwt.dispatch.server.guice.GuiceLazyActionHandlerRegistry;
import net.customware.gwt.dispatch.server.guice.ServerDispatchModule;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFactory;

public class HighwayServletModule extends ServletModule {

    protected void configureServlets() {
    	install(new ServerDispatchModule(GuiceDispatch.class, GuiceLazyActionHandlerRegistry.class));
    	bind(SecureSessionValidator.class).to(AppEngineSecureSessionValidator.class);
    	bind(HwyCommandRightsValidator.class).to(HwyCommandRightsValidatorImpl.class);    	
    	serve("/dispatch/*").with(HwyDispatchServlet.class);
    	bind(ObjectifyFactory.class).in(Singleton.class);
    	bind(HwyDaoService.class).to(HwyDaoServiceImpl.class).in(Singleton.class);
    	bind(Highway.class).to(HighwayServerImpl.class);
    }
}
