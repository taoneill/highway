package net.apptao.highway.client;

import net.apptao.highway.shared.dispatch.HwyDeleteResult;
import net.apptao.highway.shared.dispatch.HwyGetResult;
import net.apptao.highway.shared.dispatch.HwyPutResult;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HwyClientDao {
	void get(Class<?> dataType, Long dataId, AsyncCallback<HwyGetResult> callback);

	void get(Class<?> dataType, String dataName, AsyncCallback<HwyGetResult> callback);

	void get(Class<?> dataType, Iterable<?> idsOrNames, AsyncCallback<HwyGetResult> callback);

	void put(Object data, AsyncCallback<HwyPutResult> callback);

	void put(Iterable<Object> objs, AsyncCallback<HwyPutResult> callback);

	void delete(Class<?> dataType, Long dataId, AsyncCallback<HwyDeleteResult> callback);
}
