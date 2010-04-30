package net.apptao.highway.client.dispatch;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

public interface HwySecureDispatchServiceAsync {
    void execute(Action<?> action, String sessionId,  AsyncCallback<Result> callback);
}