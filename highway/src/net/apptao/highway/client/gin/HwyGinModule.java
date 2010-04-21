package net.apptao.highway.client.gin;

import net.apptao.highway.client.Highway;
import net.apptao.highway.client.dispatch.DefaultHwyDispatchAsync;
import net.apptao.highway.client.event.DefaultHwyEventBus;
import net.apptao.highway.client.event.HwyEventBus;
import net.apptao.highway.shared.dispatch.HwyDispatchAsync;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.secure.SecureDispatchAsync;

import com.google.gwt.inject.client.AbstractGinModule;

public class HwyGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(Highway.class);	// make Highway the interface not the impl		
		bind(HwyEventBus.class).to(DefaultHwyEventBus.class);
		bind(DispatchAsync.class).to(SecureDispatchAsync.class);
		bind(HwyDispatchAsync.class).to(DefaultHwyDispatchAsync.class);
	}

}
