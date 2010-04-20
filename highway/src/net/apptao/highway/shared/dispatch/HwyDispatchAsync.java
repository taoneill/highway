package net.apptao.highway.shared.dispatch;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HwyDispatchAsync {
	 <C extends HwyCommand<R>, R extends HwyResult> void call(C command, AsyncCallback<R> callback);
}
