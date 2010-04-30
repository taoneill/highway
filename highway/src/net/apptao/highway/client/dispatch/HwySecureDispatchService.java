package net.apptao.highway.client.dispatch;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.ActionException;
import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import net.customware.gwt.dispatch.shared.ServiceException;

@RemoteServiceRelativePath("hwy")
public interface HwySecureDispatchService extends RemoteService {
    Result execute(Action<?> action, String sessionId) throws ActionException, ServiceException;
}