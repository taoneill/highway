package net.apptao.highway.server;

import com.google.inject.Inject;

public class HighwayServerImpl implements Highway {
	private HwyDaoService daoService;
	
	@Inject
	public HighwayServerImpl(HwyDaoService daoService){
		this.daoService = daoService;
	}
	
	public HwyDao dao()
	{
		return daoService.begin();
	}
	
	public HwyDao dao(boolean transactional)
	{
		return daoService.beginTransaction();
	}
	
	public void register(Class<?> persisted)
	{
		daoService.register(persisted);
	}
}
