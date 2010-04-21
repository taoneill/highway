package net.apptao.highway.client.dispatch;

import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyResult;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HwyDispatchAsync {
	 <C extends HwyCommand<R>, R extends HwyResult> void call(C command, AsyncCallback<R> callback);
}
