package net.apptao.highway.client.dispatch;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HwyDispatchAsync {
	 <C extends HwyCommand<R>, R extends HwyResult> void call(C command, AsyncCallback<R> callback);
}
