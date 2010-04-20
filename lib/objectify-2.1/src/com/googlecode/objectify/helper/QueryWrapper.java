package com.googlecode.objectify.helper;

import java.util.Map;
import java.util.Set;

import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterable;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Query;

/**
 * Simple wrapper/decorator for a Query.
 *
 * @author Jeff Schnitzer <jeff@infohazard.org>
 */
public class QueryWrapper<T> implements Query<T>
{
	/** */
	Query<T> base;
	
	/** */
	public QueryWrapper(Query<T> base) 
	{
		this.base = base;
	}
	
	@Override
	public Query<T> filter(String condition, Object value)
	{
		return this.base.filter(condition, value);
	}
	
	@Override
	public Query<T> order(String condition)
	{
		return this.base.order(condition);
	}
	
	@Override
	public Query<T> ancestor(Object keyOrEntity)
	{
		return this.base.ancestor(keyOrEntity);
	}
	
	@Override
	public Query<T> limit(int value)
	{
		return this.base.limit(value);
	}
	
	@Override
	public Query<T> offset(int value)
	{
		return this.base.offset(value);
	}

	@Override
	public Query<T> cursor(Cursor value)
	{
		return this.base.cursor(value);
	}

	@Override
	public String toString()
	{
		return this.base.toString();
	}

	@Override
	public QueryResultIterator<T> iterator()
	{
		return this.base.iterator();
	}

	@Override
	public T get()
	{
		return this.base.get();
	}

	@Override
	public Key<T> getKey()
	{
		return this.base.getKey();
	}

	@Override
	public int countAll()
	{
		return this.base.countAll();
	}

	@Override
	public QueryResultIterable<T> fetch()
	{
		return this.base.fetch();
	}

	@Override
	public QueryResultIterable<Key<T>> fetchKeys()
	{
		return this.base.fetchKeys();
	}

	@Override
	public <V> Set<Key<V>> fetchParentKeys()
	{
		return this.base.fetchParentKeys();
	}

	@Override
	public <V> Map<Key<V>, V> fetchParents()
	{
		return this.base.fetchParents();
	}
}
