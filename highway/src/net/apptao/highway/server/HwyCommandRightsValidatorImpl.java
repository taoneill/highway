package net.apptao.highway.server;

import net.apptao.highway.shared.dispatch.HwyCommand;

public class HwyCommandRightsValidatorImpl implements HwyCommandRightsValidator {

	@Override
	public boolean isUnsecured(HwyCommand<?> action) {
		return false;
	}

}
