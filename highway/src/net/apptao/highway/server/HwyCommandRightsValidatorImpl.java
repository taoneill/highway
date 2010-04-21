package net.apptao.highway.server;

import com.google.inject.Inject;

import net.apptao.highway.shared.dispatch.HwyCommand;

public class HwyCommandRightsValidatorImpl implements HwyCommandRightsValidator {

	@Inject
	public HwyCommandRightsValidatorImpl() {
		
	}
	
	@Override
	public boolean isUnsecured(HwyCommand<?> action) {
		return false;
	}

}
