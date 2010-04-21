package net.apptao.highway.server;

import net.customware.gwt.dispatch.client.secure.SecureDispatchService;
import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;

import com.google.inject.Inject;

public class HighwayDispatchServlet extends HwyAbstractDispatchServlet implements SecureDispatchService {

	private final Dispatch dispatch;
    private final SecureSessionValidator sessionValidator;
    private final HwyCommandRightsValidator commandRightsValidator;

    @Inject
    public HighwayDispatchServlet(Dispatch dispatch, SecureSessionValidator sessionValidator,
    							HwyCommandRightsValidator commandRightsValidator) {
        this.dispatch = dispatch;
        this.sessionValidator = sessionValidator;
        this.commandRightsValidator = commandRightsValidator;
    }

	@Override
	protected Dispatch getDispatch() {
		return dispatch;
	}

	@Override
	protected SecureSessionValidator getSessionValidator() {
		return sessionValidator;
	}

	@Override
	protected HwyCommandRightsValidator getCommandRightsValidator() {
		return commandRightsValidator;
	}

}
