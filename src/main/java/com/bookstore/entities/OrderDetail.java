/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entities;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	private OrderDetail id=new OrderDetail();
	private Book book;
	private BookOrder bookOrder;
	private int quantity;
	private float subtotal;
	
	
	public OrderDetail() {
		super();
		//TODO Auto-generated constructor stub
	}


	public OrderDetail(OrderDetail id, Book book, BookOrder bookOrder, int quantity, float subtotal) {
		super();
		this.id = id;
		this.book = book;
		this.bookOrder = bookOrder;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public OrderDetail getId() {
		return id;
	}



	public void setId(OrderDetail id) {
		this.id = id;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
		this.id.setBook(book);
	}



	public BookOrder getBookOrder() {
		return bookOrder;
	}



	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
		this.id.setBookOrder(bookOrder);
	}





	public int getQuantity() {
		return quantity;
	}





	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





	public float getSubtotal() {
		return subtotal;
	}





	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
