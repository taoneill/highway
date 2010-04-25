package net.apptao.highway.server;

import net.apptao.highway.server.dao.HwyDao;

public interface Highway {

	/**
	 * Begin and new non-transactional data access operation.
	 * @return A new instance of a non-transactional @see HwyDao, which directly extends @see Objectify.
	 */
	public abstract HwyDao dao();

	/**
	 * Begin and new transactional data access operation. 
	 * @return A new instance of a transactional @see HwyDao, which directly extends @see Objectify.
	 */
	public abstract HwyDao dao(boolean transactional);

	/**
	 * Register a class for persistence.
	 * The class must be annotated following the @see Objectify standards.
	 * All classes must be registered before any data access operations are begun.
	 */
	public abstract void register(Class<?> persisted);

}