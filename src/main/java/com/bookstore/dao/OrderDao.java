/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.Book;
import com.bookstore.entities.BookOrder;
import com.bookstore.entities.Category;
import com.bookstore.entities.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao implements GenericDao<BookOrder>{

    private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public OrderDao(Connection con) {
        this.con=con;
    }
    
    public OrderDao() {
    }

	@Override
	public int create(BookOrder order) {
		 int status=0;
	        try {
	           
	            query="insert into Order(customer_id,order_date,shipping_address,recipient_name, payment_method,total,status) values(?,?,?,?,?,?,?)";
	            ps=this.con.prepareStatement(query);
	            
	            
	            ps.setInt(1, order.getCustomer().getCust_id());
	            ps.setObject(2, new Date());
	            ps.setString(3, order.getShippingAddress());
	            ps.setString(4, order.getRecipientName());
	            ps.setString(5, order.getPaymentMethod());
	            ps.setFloat(6, order.getTotal());
	            ps.setString(7, order.getStatus());
	            
	            status = ps.executeUpdate();
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return status;
		
	}

	@Override
	public int update(BookOrder t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookOrder> listAll() {
		List<BookOrder> orderList=new ArrayList<>();
        BookOrder order=null;
        try {
            query="select * from book_order";
            ps=this.con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
            	 order.setOrder_id(rs.getInt("order_id"));
            	 
            	 String query2="select * from Customer where customer_id=?";
                 PreparedStatement ps2=this.con.prepareStatement(query2);
                 ps2.setInt(1, rs.getInt("customer_id"));
                 ResultSet rs2=ps2.executeQuery();
                 Customer customer=null;
                 if(rs2.next())
                 {
                 	customer=new Customer();
                     customer.setCust_id(rs2.getInt("customer_id"));
                     customer.setFullName(rs2.getString("fullname"));
                 }
                 
                 order.setCustomer(customer);
                 order.setOrderDate(rs.getDate("order_date"));
                 order.setShippingAddress(rs.getString("shipping_address"));
                 order.setRecipientName(rs.getString("recipient_name"));
                 order.setRecipientPhone(rs2.getString("recipient_phone"));
                 order.setPaymentMethod(rs2.getString("payment_method"));
                 order.setTotal(rs2.getFloat("payment_method"));
                 order.setStatus(rs2.getString("status"));
                
            }     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public BookOrder getBookOrderById(int id){
        BookOrder order=new BookOrder();
        try {
            query="select * from book_order where order_id=?";
            ps=this.con.prepareStatement(query);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next())
            {
            	 order.setOrder_id(rs.getInt("order_id"));
            	 
            	 String query2="select * from Customer where customer_id=?";
                 PreparedStatement ps2=this.con.prepareStatement(query2);
                 ps2.setInt(1, rs.getInt("customer_id"));
                 ResultSet rs2=ps2.executeQuery();
                 Customer customer=null;
                 if(rs2.next())
                 {
                 	customer=new Customer();
                     customer.setCust_id(rs2.getInt("customer_id"));
                     customer.setFullName(rs2.getString("fullname"));
                 }
                 
                 order.setCustomer(customer);
                 order.setOrderDate(rs.getDate("order_date"));
                 order.setShippingAddress(rs.getString("shipping_address"));
                 order.setRecipientName(rs.getString("recipient_name"));
                 order.setRecipientPhone(rs2.getString("recipient_phone"));
                 order.setPaymentMethod(rs2.getString("payment_method"));
                 order.setTotal(rs2.getFloat("payment_method"));
                 order.setStatus(rs2.getString("status"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
	
   
}
