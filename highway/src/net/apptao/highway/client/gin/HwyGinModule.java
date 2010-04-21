package net.apptao.highway.client.gin;

import net.apptao.highway.client.HighwayClientImpl;
import net.apptao.highway.client.dispatch.HwyDispatchAsyncImpl;
import net.apptao.highway.client.event.HwyEventBusImpl;
import net.apptao.highway.client.event.HwyEventBus;
import net.apptao.highway.shared.dispatch.HwyDispatchAsync;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.secure.SecureDispatchAsync;

import com.google.gwt.inject.client.AbstractGinModule;

public class HwyGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(HighwayClientImpl.class);	// make Highway the interface not the impl		
		bind(HwyEventBus.class).to(HwyEventBusImpl.class);
		bind(DispatchAsync.class).to(SecureDispatchAsync.class);
		bind(HwyDispatchAsync.class).to(HwyDispatchAsyncImpl.class);
	}

}
