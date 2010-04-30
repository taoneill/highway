package net.apptao.highway.client.dispatch;

import net.customware.gwt.dispatch.client.secure.CookieSecureSessionAccessor;

public class HwySecureSessionAccessor extends CookieSecureSessionAccessor {

	private final static String COOKIENAME = "HWYSID";

    public HwySecureSessionAccessor() {
        super( COOKIENAME );
    }

}
