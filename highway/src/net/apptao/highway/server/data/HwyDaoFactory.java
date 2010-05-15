package net.apptao.highway.server.data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Transaction;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

public class HwyDaoFactory extends ObjectifyFactory {
	@Override
	protected Objectify createObjectify(DatastoreService ds, Transaction txn) 
	{
		return new HwyDaoImpl(this, ds, txn);
	}
}
