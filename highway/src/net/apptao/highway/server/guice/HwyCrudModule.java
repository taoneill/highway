package net.apptao.highway.server.guice;

import net.apptao.highway.server.dispatch.HwyPutHandler;
import net.apptao.highway.shared.dispatch.HwyPut;

public class HwyCrudModule extends HighwayModule {
	@Override
	protected void configureModule() {
		bindCommand(HwyPut.class, HwyPutHandler.class);
	}
}
