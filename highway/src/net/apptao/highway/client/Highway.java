package net.apptao.highway.client;

import java.util.Map;

import net.apptao.highway.client.dispatch.HwyCommand;
import net.apptao.highway.client.dispatch.HwyDelete;
import net.apptao.highway.client.dispatch.HwyDeleteResult;
import net.apptao.highway.client.dispatch.HwyDispatchAsync;
import net.apptao.highway.client.dispatch.HwyGet;
import net.apptao.highway.client.dispatch.HwyGetResult;
import net.apptao.highway.client.dispatch.HwyPut;
import net.apptao.highway.client.dispatch.HwyPutResult;
import net.apptao.highway.client.dispatch.HwyResult;
import net.apptao.highway.client.event.HwyEventBus;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class Highway {
	
	private HwyDispatchAsync dispatch;
	private HwyEventBus eventBus;

	@Inject
	public Highway(HwyDispatchAsync dispatch, HwyEventBus eventBus, HwyClientCache cache){	//, HwyClientDao) :/
		this.dispatch = dispatch;
		this.eventBus = eventBus;
	}

	// Command
	public void call(HwyCommand<HwyResult> command, AsyncCallback<HwyResult> callback) {
		dispatch.call(command, callback);
	}
	
//	public void batch(HwyBatchFailBehavior behavior, Map<HwyCommand<HwyResult>, AsyncCallback<HwyResult>> commands, ){
//		// send as a single request (let fail or rollback whole batch)
//	}
//	
//	public void queue(Map<HwyCommand<HwyResult>, AsyncCallback<HwyResult>> commands, HwyQueueFailBehavior behavior){
//		// wait until each request comes back before sending the next (keep going on fail or stop queue)
//	}
//	
	// Data (Local-Remote Storage agnostic)
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

	// Event
	public HwyEventBus getEventBus(){
		return eventBus;
	}
	
	public void fire(GwtEvent<?> event) {
		eventBus.fireEvent(event);
	}
	
	public <H extends EventHandler> HandlerRegistration handle(GwtEvent.Type<H> type, final H handler) {
		return eventBus.addHandler(type, handler);
	}
		
	// Binding
	//public void bind(HwyData data, HwyBinder binder, Object value);
}
