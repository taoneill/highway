package net.apptao.highway.server;

import net.apptao.highway.server.dao.HwyDao;

public interface Highway {

	public abstract HwyDao dao();

	public abstract HwyDao dao(boolean transactional);

	public abstract void register(Class<?> persisted);

}