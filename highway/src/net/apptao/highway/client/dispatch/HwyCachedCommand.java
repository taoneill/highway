package net.apptao.highway.client.dispatch;

import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyResult;
import net.customware.gwt.dispatch.shared.Action;

public interface HwyCachedCommand<R extends HwyResult> extends HwyCommand<R>{
	Long secondsUntilExpire();
}
