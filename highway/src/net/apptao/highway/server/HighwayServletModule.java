package net.apptao.highway.server;

import net.customware.gwt.dispatch.server.ActionHandlerRegistry;
import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.server.appengine.AppEngineSecureSessionValidator;
import net.customware.gwt.dispatch.server.guice.GuiceDispatch;
import net.customware.gwt.dispatch.server.guice.GuiceLazyActionHandlerRegistry;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;

import com.google.inject.servlet.ServletModule;

public class HighwayServletModule extends ServletModule {

    protected void configureServlets() {
    	bind(SecureSessionValidator.class).to(AppEngineSecureSessionValidator.class);
    	bind(ActionHandlerRegistry.class).to(GuiceLazyActionHandlerRegistry.class);
    	bind(Dispatch.class).to(GuiceDispatch.class);
    	
    	
    	serve("/dispatch/*").with(HighwayDispatchServlet.class);

    	
    }
}
