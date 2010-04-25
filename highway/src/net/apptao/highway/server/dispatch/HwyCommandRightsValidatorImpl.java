package net.apptao.highway.server.dispatch;

import java.lang.annotation.Annotation;

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
		Unsecured annotation = handlerRegistry.findHandler(command).getClass().getAnnotation(Unsecured.class);
		if(annotation != null){
			return true;
		}
		return false;
	}

}
