package net.apptao.highway.server;

import com.google.inject.Inject;

public class Highway implements HwyServer {
	@Inject
	public Highway(HwyDispatch dispatch, HwyDao dao){
		
	}
	public void execute(){}
	public void put(Object obj){}
	public Object get(){
		return null;
	}
	
}
