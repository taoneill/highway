package net.apptao.highway.server;

import net.apptao.highway.client.dispatch.HwySecureDispatchService;
import net.apptao.highway.server.dispatch.HwyCommandRightsValidator;
import net.customware.gwt.dispatch.server.Dispatch;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class HwyDispatchServlet extends HwyAbstractDispatchServlet implements HwySecureDispatchService {

	private final Dispatch dispatch;
    private final HwySecureSessionValidator sessionValidator;
    private final HwyCommandRightsValidator commandRightsValidator;

    @Inject
    public HwyDispatchServlet(Dispatch dispatch, HwySecureSessionValidator sessionValidator,
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
	protected HwySecureSessionValidator getSessionValidator() {
		return sessionValidator;
	}

	@Override
	protected HwyCommandRightsValidator getCommandRightsValidator() {
		return commandRightsValidator;
	}

}
