package net.apptao.highway.server.dispatch;

import net.customware.gwt.dispatch.server.ActionHandlerRegistry;
import net.customware.gwt.dispatch.shared.Action;

import com.google.inject.Inject;

public class HwyCommandRightsValidatorImpl implements HwyCommandRightsValidator {

	private ActionHandlerRegistry handlerRegistry;

	@Inject
	public HwyCommandRightsValidatorImpl(ActionHandlerRegistry handlerRegistry) {
		this.handlerRegistry = handlerRegistry;
	}

	@Override
	public boolean isUnsecured(Action<?> command) {
		Unsecured annotation = handlerRegistry.findHandler(command).getClass().getAnnotation(Unsecured.class);
		if(annotation != null){
			return true;
		}
		return false;
	}

}
