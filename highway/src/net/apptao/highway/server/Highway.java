package net.apptao.highway.server;

public interface Highway {

	public abstract HwyDao dao();

	public abstract HwyDao dao(boolean transactional);

	public abstract void register(Class<?> persisted);

}