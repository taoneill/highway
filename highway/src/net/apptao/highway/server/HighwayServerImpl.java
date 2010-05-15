package net.apptao.highway.server;

import net.apptao.highway.server.data.HwyDao;
import net.apptao.highway.server.data.HwyDaoFactory;

import com.google.inject.Inject;
import com.googlecode.objectify.ObjectifyService;

public class HighwayServerImpl implements Highway {
	
	private HwyDaoFactory ofyFactory;

	@Inject
	public HighwayServerImpl(HwyDaoFactory ofyFactory){
		this.ofyFactory = ofyFactory;
	}
	
	public HwyDao dao()
	{
		return (HwyDao)ofyFactory.begin();
	}
	
	public HwyDao dao(boolean transactional)
	{
		if(transactional)
			return (HwyDao)ofyFactory.beginTransaction();
		else
			return dao();
	}
	
	public void register(Class<?> persisted)
	{
		ObjectifyService.register(persisted);
	}
}
