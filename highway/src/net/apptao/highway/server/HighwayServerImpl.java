package net.apptao.highway.server;

import com.google.inject.Inject;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class HighwayServerImpl implements Highway {
	
	@Inject
	public HighwayServerImpl(){
	}
	
	public Objectify dao()
	{
		return ObjectifyService.begin();
	}
	
	public Objectify dao(boolean transactional)
	{
		if(transactional)
			return ObjectifyService.beginTransaction();
		else
			return dao();
	}
	
	public void register(Class<?> persisted)
	{
		ObjectifyService.register(persisted);
	}
}
