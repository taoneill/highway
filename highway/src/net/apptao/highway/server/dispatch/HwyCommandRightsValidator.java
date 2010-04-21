package net.apptao.highway.server.dispatch;

import net.apptao.highway.shared.dispatch.HwyCommand;

public interface HwyCommandRightsValidator {
	boolean isUnsecured(HwyCommand<?> action);	// default is secure
	
	//boolean hasRights(HwyCommand command);	
	// TODO someday, call the local user service and use a permissions based system	
	
}
