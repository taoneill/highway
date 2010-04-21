package net.apptao.highway.server.dao;

public interface HwyDaoService {
	HwyDao begin();
	HwyDao beginTransaction();
	void register(Class<?> clazz);
	void setDatastoreTimeoutRetryCount(int value);
	int getDatastoreTimeoutRetryCount();
}
