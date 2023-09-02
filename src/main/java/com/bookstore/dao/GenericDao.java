package com.bookstore.dao;

import java.util.List;

interface GenericDao<T> {
	
	public int create(T t);
	public int update(T t) ;
	public int delete(int id);
//	public T get(Object id);
	public List<T> listAll();
	public long count();
	
}
