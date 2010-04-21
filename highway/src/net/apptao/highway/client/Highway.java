package net.apptao.highway.client;

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
	public abstract void call(HwyCommand<HwyResult> command,
			AsyncCallback<HwyResult> callback);

	//	public void batch(HwyBatchFailBehavior behavior, Map<HwyCommand<HwyResult>, AsyncCallback<HwyResult>> commands, ){
	//		// send as a single request (let fail or rollback whole batch)
	//	}
	//	
	//	public void queue(Map<HwyCommand<HwyResult>, AsyncCallback<HwyResult>> commands, HwyQueueFailBehavior behavior){
	//		// wait until each request comes back before sending the next (keep going on fail or stop queue)
	//	}
	//	
	// Data (Local-Remote Storage agnostic)
	public abstract void get(Class<?> dataType, Long dataId,
			AsyncCallback<HwyGetResult> callback);

	public abstract void get(Class<?> dataType, String dataName,
			AsyncCallback<HwyGetResult> callback);

	public abstract void get(Class<?> dataType, Iterable<?> idsOrNames,
			AsyncCallback<HwyGetResult> callback);

	public abstract void put(Object data, AsyncCallback<HwyPutResult> callback);

	public abstract void put(Iterable<Object> objs,
			AsyncCallback<HwyPutResult> callback);

	public abstract void delete(Class<?> dataType, Long dataId,
			AsyncCallback<HwyDeleteResult> callback);

	// Event
	public abstract HwyEventBus getEventBus();

	public abstract void fire(GwtEvent<?> event);

	public abstract <H extends EventHandler> HandlerRegistration handle(
			GwtEvent.Type<H> type, final H handler);

}