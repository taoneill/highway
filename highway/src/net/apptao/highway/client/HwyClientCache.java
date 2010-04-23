package net.apptao.highway.client;

import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyResult;

public interface HwyClientCache {
	<R extends HwyResult> R get(HwyCommand<R> command);
	<R extends HwyResult> void put(HwyCommand<R> command, R result, Long secondsUntilExpire);
	void delete(HwyCommand<? extends HwyResult> command);
}
