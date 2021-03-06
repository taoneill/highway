package net.apptao.highway.client;

import net.apptao.highway.client.dispatch.HwyDispatchAsync;
import net.apptao.highway.client.event.HwyEventBus;
import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyDeleteResult;
import net.apptao.highway.shared.dispatch.HwyGetResult;
import net.apptao.highway.shared.dispatch.HwyPutResult;
import net.apptao.highway.shared.dispatch.HwyResult;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Highway {

	// Command
	void call(HwyCommand<HwyResult> command,
			AsyncCallback<HwyResult> callback);
	
	//HwyDispatchAsync call();

	// Data (Local-Remote Storage agnostic)
	void get(Class<?> dataType, Long dataId, AsyncCallback<HwyGetResult> callback);

	void get(Class<?> dataType, String dataName, AsyncCallback<HwyGetResult> callback);

	void get(Class<?> dataType, Iterable<?> idsOrNames, AsyncCallback<HwyGetResult> callback);

	void put(Object data, AsyncCallback<HwyPutResult> callback);

	void put(Iterable<Object> objs, AsyncCallback<HwyPutResult> callback);

	void delete(Class<?> dataType, Long dataId, AsyncCallback<HwyDeleteResult> callback);

	// Event
	HwyEventBus getEventBus();

	void fire(GwtEvent<?> event);

	<H extends EventHandler> HandlerRegistration handle(
			GwtEvent.Type<H> type, final H handler);

}