package net.apptao.highway.server;

import net.apptao.highway.server.dao.HwyDao;
import net.apptao.highway.server.dao.HwyDaoService;
import net.customware.gwt.dispatch.server.Dispatch;

import com.google.inject.Inject;

public class HighwayServerImpl implements Highway {
	private HwyDaoService daoService;
	
	@Inject
	public HighwayServerImpl(Dispatch dispatch, HwyDaoService daoService){
		this.daoService = daoService;
	}
	
	public HwyDao dao()
	{
		return daoService.begin();
	}
	
	public HwyDao dao(boolean transactional)
	{
		if(transactional)
			return daoService.beginTransaction();
		else
			return dao();
	}
	
	public void register(Class<?> persisted)
	{
		daoService.register(persisted);
	}
}
