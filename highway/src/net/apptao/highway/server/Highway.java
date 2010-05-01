package net.apptao.highway.server;

import com.googlecode.objectify.Objectify;

public interface Highway {

	/**
	 * Begin a new non-transactional datastore access operation.
	 * @return A new instance of an @see Objectify object.
	 */
	public abstract Objectify dao();

	/**
	 * Begin a new transactional datastore access operation by passing true. 
	 * @return A new instance of an @see Objectify object.
	 */
	public abstract Objectify dao(boolean transactional);

	/**
	 * Register a class for persistence.
	 * The class must be annotated following the @see Objectify standards.
	 * All classes must be registered before any data access operations are begun.
	 */
	public abstract void register(Class<?> persisted);

}