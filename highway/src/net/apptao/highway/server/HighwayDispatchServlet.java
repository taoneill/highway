package net.apptao.highway.server;

import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.server.guice.GuiceSecureDispatchServlet;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;

public class HighwayDispatchServlet extends GuiceSecureDispatchServlet {

	public HighwayDispatchServlet(Dispatch dispatch, SecureSessionValidator sessionValidator) {
		super(dispatch, sessionValidator);
		// TODO Auto-generated constructor stub
	}

}
