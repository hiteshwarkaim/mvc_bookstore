package com.bookstore.dao;

import java.util.List;

interface GenericDao<T> {
	
	public int create(T t);
	public T update(T t) ;
	public void delete(Object id);
//	public T get(Object id);
	public List<T> listAll();
	public long count();
	
}
