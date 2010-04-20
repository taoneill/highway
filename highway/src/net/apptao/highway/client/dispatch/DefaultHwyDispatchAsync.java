package net.apptao.highway.client.dispatch;

import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyDispatchAsync;
import net.apptao.highway.shared.dispatch.HwyResult;
import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class DefaultHwyDispatchAsync implements HwyDispatchAsync{

	private DispatchAsync dispatch;

	@Inject
	public DefaultHwyDispatchAsync(DispatchAsync dispatch){
		this.dispatch = dispatch;
	}

	@Override
	public <C extends HwyCommand<R>, R extends HwyResult> void call(C command, AsyncCallback<R> callback) {
		dispatch.execute(command, callback);		
	}}
