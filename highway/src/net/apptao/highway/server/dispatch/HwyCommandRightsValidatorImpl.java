package net.apptao.highway.server.dispatch;

import com.google.inject.Inject;

import net.apptao.highway.shared.dispatch.HwyCommand;
import net.customware.gwt.dispatch.server.ActionHandlerRegistry;

public class HwyCommandRightsValidatorImpl implements HwyCommandRightsValidator {

	private ActionHandlerRegistry handlerRegistry;

	@Inject
	public HwyCommandRightsValidatorImpl(ActionHandlerRegistry handlerRegistry) {
		this.handlerRegistry = handlerRegistry;
	}
	
	@Override
	public boolean isUnsecured(HwyCommand<?> command) {
		HwyHandler handler = (HwyHandler) handlerRegistry.findHandler(command);
		if(handler.getClass().getAnnotation(Unsecured.class) != null)
			return true;
		else
			return false;
	}

}
