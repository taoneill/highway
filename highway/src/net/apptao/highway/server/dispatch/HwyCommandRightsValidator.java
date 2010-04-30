package net.apptao.highway.server.dispatch;

import net.customware.gwt.dispatch.shared.Action;

public interface HwyCommandRightsValidator {
	boolean isUnsecured(Action<?> action);	// default is secure
	
	//boolean hasRights(HwyCommand command);	
	// TODO someday, call the local user service and use a permissions based system	
	
}
