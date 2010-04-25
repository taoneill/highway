package net.apptao.highway.server.guice;

import net.apptao.highway.server.dispatch.HwyHandler;
import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyResult;
import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import com.googlecode.objectify.ObjectifyService;

public abstract class HighwayModule extends ActionHandlerModule {
	
	protected <C extends HwyCommand<R>, R extends HwyResult> void bindCommand(Class<C> commandClass,
																	Class<? extends HwyHandler<C, R>> handlerClass){
		bindHandler(commandClass, handlerClass);
	}
	
	protected void register(Class<?> modelClass){
		ObjectifyService.register(modelClass);
	}
	
	@Override
	protected void configureHandlers() {
		configureModule();
	}

	protected abstract void configureModule();
}
