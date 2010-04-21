package net.apptao.highway.server.dao;

import com.google.inject.Inject;
import com.googlecode.objectify.ObjectifyFactory;


public class HwyDaoServiceImpl implements HwyDaoService {

	private ObjectifyFactory factory;

	@Inject
	public HwyDaoServiceImpl(ObjectifyFactory fact){
		this.factory = fact;
	}
	
	@Override
	public HwyDao begin() {
		return (HwyDao) factory.begin();
	}

	@Override
	public HwyDao beginTransaction() {
		return (HwyDao) factory.beginTransaction();
	}

	@Override
	public int getDatastoreTimeoutRetryCount() {
		return factory.getDatastoreTimeoutRetryCount();
	}

	@Override
	public void register(Class<?> modelClass) {
		factory.register(modelClass);
	}

	@Override
	public void setDatastoreTimeoutRetryCount(int value) {
		factory.setDatastoreTimeoutRetryCount(value);
	}

}
