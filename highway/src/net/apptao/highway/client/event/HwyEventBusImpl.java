package net.apptao.highway.client.event;

import com.google.gwt.event.shared.HandlerManager;
import com.google.inject.Singleton;

@Singleton
public class HwyEventBusImpl extends HandlerManager implements HwyEventBus{

	public HwyEventBusImpl() {
		super(null);
	}
	
}
