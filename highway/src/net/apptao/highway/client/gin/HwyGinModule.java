package net.apptao.highway.client.gin;

import net.apptao.highway.client.Highway;
import net.apptao.highway.client.HighwayClientImpl;
import net.apptao.highway.client.dispatch.HwyDispatchAsync;
import net.apptao.highway.client.dispatch.HwyDispatchAsyncImpl;
import net.apptao.highway.client.dispatch.RichDispatchAsync;
import net.apptao.highway.client.event.HwyEventBus;
import net.apptao.highway.client.event.HwyEventBusImpl;
import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.inject.client.AbstractGinModule;

public class HwyGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(Highway.class).to(HighwayClientImpl.class);		
		bind(HwyEventBus.class).to(HwyEventBusImpl.class);
		bind(DispatchAsync.class).to(RichDispatchAsync.class);
		bind(HwyDispatchAsync.class).to(HwyDispatchAsyncImpl.class);
	}

}
