package net.apptao.highway.client;

import net.apptao.highway.client.dispatch.HwyDispatchAsync;
import net.apptao.highway.client.event.HwyEventBus;
import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyDelete;
import net.apptao.highway.shared.dispatch.HwyDeleteResult;
import net.apptao.highway.shared.dispatch.HwyGet;
import net.apptao.highway.shared.dispatch.HwyGetResult;
import net.apptao.highway.shared.dispatch.HwyPut;
import net.apptao.highway.shared.dispatch.HwyPutResult;
import net.apptao.highway.shared.dispatch.HwyResult;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class HighwayClientImpl implements Highway{
	
	private HwyDispatchAsync dispatch;
	private HwyEventBus eventBus;

	@Inject
	public HighwayClientImpl(HwyDispatchAsync dispatch, HwyEventBus eventBus){
		this.dispatch = dispatch;
		this.eventBus = eventBus;
	}

	public void call(HwyCommand<HwyResult> command, AsyncCallback<HwyResult> callback) {
		dispatch.call(command, callback);
	}
	
	public void get(Class<?> dataType, Long dataId, AsyncCallback<HwyGetResult> callback) {
		dispatch.call(new HwyGet(dataType, dataId), callback);
	}

	public void get(Class<?> dataType, String dataName, AsyncCallback<HwyGetResult> callback) {
		dispatch.call(new HwyGet(dataType, dataName), callback);
	}

	public void get(Class<?> dataType, Iterable<?> idsOrNames, AsyncCallback<HwyGetResult> callback){
		dispatch.call(new HwyGet(dataType, idsOrNames), callback);		
	}
	
	public void put(Object data, AsyncCallback<HwyPutResult> callback) {
		dispatch.call(new HwyPut(data), callback);
	}

	public void put(Iterable<Object> objs, AsyncCallback<HwyPutResult> callback) {
		dispatch.call(new HwyPut(objs), callback);
	}

	public void delete(Class<?> dataType, Long dataId, AsyncCallback<HwyDeleteResult> callback) {
		dispatch.call(new HwyDelete(dataId), callback);
	}

	public HwyEventBus getEventBus(){
		return eventBus;
	}

	public void fire(GwtEvent<?> event) {
		eventBus.fireEvent(event);
	}
	

	public <H extends EventHandler> HandlerRegistration handle(GwtEvent.Type<H> type, final H handler) {
		return eventBus.addHandler(type, handler);
	}
}
