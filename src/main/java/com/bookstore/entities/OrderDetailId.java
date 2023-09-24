/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entities;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailId implements Serializable{
	
	private Book book;
	private BookOrder bookOrder;
	
	
	public OrderDetailId() {
		super();
		//TODO Auto-generated constructor stub
	}


	public OrderDetailId(Book book, BookOrder bookOrder) {
		super();
		this.book = book;
		this.bookOrder = bookOrder;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public BookOrder getBookOrder() {
		return bookOrder;
	}


	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}


	@Override
	public int hashCode() {
		return Objects.hash(book, bookOrder);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailId other = (OrderDetailId) obj;
		return Objects.equals(book, other.book) && Objects.equals(bookOrder, other.bookOrder);
	}
	
	

}
