package net.apptao.highway.server.dispatch;

import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyResult;
import net.customware.gwt.dispatch.server.ActionHandler;

public interface HwyHandler<C extends HwyCommand<R>, R extends HwyResult> extends ActionHandler<C,R> {
	
}
