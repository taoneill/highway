package net.apptao.highway.server.data;

import java.util.Map;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.impl.ObjectifyImpl;

public class HwyDaoImpl extends ObjectifyImpl implements HwyDao {

	public HwyDaoImpl(ObjectifyFactory fact, DatastoreService ds,
			Transaction txn) {
		super(fact, ds, txn);
	}

	@Override
	public <T> Map<Key<T>, T> get(Iterable<? extends Key<? extends T>> keys) {
		Map<Key<T>, T> entities = super.get(keys);
		for(Key<T> key : entities.keySet()) {
			T entity = entities.get(key);
			if(entities.get(key) instanceof PropertyBag) {
				getProperties(key, (PropertyBag)entity);
			}
		}
		return entities;
	}
	
	@Override
	public <T> T get(Key<? extends T> key) throws EntityNotFoundException {
		T entity = super.get(key);
		getProperties(key, (PropertyBag)entity);
		return entity;
	}

	@Override
	public <T> T get(Class<? extends T> clazz, long id)
			throws EntityNotFoundException {
		T entity = super.get(clazz, id);
		getProperties(clazz.getName(), id, (PropertyBag)entity);
		return entity;
	}

	@Override
	public <T> T get(Class<? extends T> clazz, String name)
			throws EntityNotFoundException {
		T entity = super.get(clazz, name);
		getProperties(clazz.getName(), name, (PropertyBag)entity);
		return entity;
	}

	@Override
	public <S, T> Map<S, T> get(Class<? extends T> clazz, Iterable<S> idsOrNames) {
		Map<S, T> entities = super.get(clazz, idsOrNames);;
		for(S key : entities.keySet()) {
			T entity = entities.get(key);
			if(entities.get(key) instanceof PropertyBag) {
				if(key instanceof String)
					getProperties(clazz.getName(), (String)key, (PropertyBag)entity);
				else
					getProperties(clazz.getName(), (Long)key, (PropertyBag)entity);
			}
		}
		return entities;
	}

	@Override
	public <T> T find(Key<? extends T> key) {
		T entity = super.find(key);
		getProperties(key, (PropertyBag)entity);
		return entity;
	}

	@Override
	public <T> T find(Class<? extends T> clazz, long id) {
		T entity = super.find(clazz, id);
		getProperties(clazz.getName(), id, (PropertyBag)entity);
		return entity;
	}

	@Override
	public <T> T find(Class<? extends T> clazz, String name) {
		T entity = super.find(clazz, name);
		getProperties(clazz.getName(), name, (PropertyBag)entity);
		return entity;
	}

	@Override
	public <T> Key<T> put(T object) {
		Key<T> key = super.put(object);
		if(object instanceof PropertyBag) {
			putProperties(key, (PropertyBag)object);
		}
		return key;
	}

	@Override
	public <T> Map<Key<T>, T> put(Iterable<? extends T> objects) {
		Map<Key<T>, T> keyAndInstances = super.put(objects);
		for(Key<T> key : keyAndInstances.keySet()) {
			T object = keyAndInstances.get(key);
			if(object instanceof PropertyBag) {
				putProperties(key, (PropertyBag)object);
			}
		}
		return keyAndInstances;
	}

	@Override
	public <T> Query<T> query() {
		return super.query();
	}

	@Override
	public <T> Query<T> query(Class<T> clazz) {
		return super.query(clazz);
	}
	
	@Override
	public void delete(Object keyOrEntity) {
		super.delete(keyOrEntity);
	}

	@Override
	public void delete(Iterable<?> keysOrEntities) {
		super.delete(keysOrEntities);

	}

	@Override
	public <T> void delete(Class<T> clazz, long id) {
		super.delete(clazz, id);
	}

	@Override
	public <T> void delete(Class<T> clazz, String name) {
		super.delete(clazz, name);
	}

	@Override
	public DatastoreService getDatastore() {
		return super.getDatastore();
	}

	@Override
	public ObjectifyFactory getFactory() {
		return super.getFactory();
	}

	@Override
	public Transaction getTxn() {
		return super.getTxn();
	}

	private void getProperties(Key<?> key, PropertyBag entity) {
		getProperties(KeyFactory.createKey(key.getKindClassName(), key.getId()), entity);
	}
	
	private void getProperties(String className, long id, PropertyBag entity) {
		getProperties(KeyFactory.createKey(className, id), entity);
	}
	
	private void getProperties(String className, String name, PropertyBag entity) {
		getProperties(KeyFactory.createKey(className, name), entity);
	}

	private void getProperties(com.google.appengine.api.datastore.Key key , PropertyBag entity) {
		try {
			Entity object = ObjectifyService.begin().getDatastore()
								.get(key);
			Map<String, Object> properties = object.getProperties();
			for(String propertyName : properties.keySet()) {
				if(entity.getClass().getField(propertyName) == null) {
					Object value = object.getProperty(propertyName);
					entity.set(propertyName, value);
				}
			}
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void putProperties(Key<?> key, PropertyBag object) {
		PropertyBag propertyBag = ((PropertyBag)object);
		try {
			Entity entity = this.ds.get(KeyFactory.createKey(key.getKindClassName(), key.getId()));
			for(String propertyName : propertyBag.properties().keySet()){
				Object value = propertyBag.get(propertyName);
				entity.setProperty(propertyName, value);
				this.ds.put(entity);
			
			}
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
