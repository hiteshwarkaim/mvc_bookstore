/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.*;

public class BookOrder implements Serializable{
    private int order_id;
    private Customer customer;
    private Date orderDate;
    private String shippingAddress;
    private String recipientName;
    private String recipientPhone;
    private String paymentMethod;
    private float total;
    private String status;
    
   

	private Set<OrderDetail> orderDetails=new HashSet<>(0);

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	

	public BookOrder(int order_id, Customer customer, Date orderDate, String shippingAddress, String recipientName,
			String recipientPhone, String paymentMethod, float total, String status, 
			Set<OrderDetail> orderDetails) {
		super();
		this.order_id = order_id;
		this.customer = customer;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.status = status;
		this.orderDetails = orderDetails;
	}

	public BookOrder() {
		super();
		//TODO Auto-generated constructor stub
	}

	@Transient
	public int getBookCopies() {
		int total=0;
		
		for(OrderDetail orderDetail:orderDetails) {
			total+=orderDetail.getQuantity();
		}
		
		return total;
	}

	@Override
	public String toString() {
		return "BookOrder [order_id=" + order_id + ", customer=" + customer + ", orderDate=" + orderDate
				+ ", shippingAddress=" + shippingAddress + ", recipientName=" + recipientName + ", recipientPhone="
				+ recipientPhone + ", paymentMethod=" + paymentMethod + ", total=" + total + ", status=" + status
				+  ", orderDetails=" + orderDetails + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(order_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookOrder other = (BookOrder) obj;
		return order_id == other.order_id;
	}

	
    
}
