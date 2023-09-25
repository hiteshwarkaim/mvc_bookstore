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
import com.bookstore.entities.OrderDetail;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
           
            query="insert into book_order(customer_id,order_date,shipping_address,recipient_name,recipient_phone, payment_method,total,status) values(?,?,?,?,?,?,?,?)";
            ps=this.con.prepareStatement(query);
            
            ps.setInt(1, order.getCustomer().getCust_id());
            ps.setObject(2, new Date());
            ps.setString(3, order.getShippingAddress());
            ps.setString(4, order.getRecipientName());
            ps.setString(5, order.getRecipientPhone());
            ps.setString(6, order.getPaymentMethod());
            ps.setFloat(7, order.getTotal());
            ps.setString(8, "Processing");
            
            status = ps.executeUpdate();
            
            
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
	
    }
    
	public int create(BookOrder order,OrderDetail orderDetail) {
		 int status=0;
		 
	        try {
	           
	            query="insert into book_order(customer_id,order_date,shipping_address,recipient_name,recipient_phone, payment_method,total,status) values(?,?,?,?,?,?,?,?)";
	            ps=this.con.prepareStatement(query);
	            
	            ps.setInt(1, order.getCustomer().getCust_id());
	            ps.setObject(2, new Date());
	            ps.setString(3, order.getShippingAddress());
	            ps.setString(4, order.getRecipientName());
	            ps.setString(5, order.getRecipientPhone());
	            ps.setString(6, order.getPaymentMethod());
	            ps.setFloat(7, order.getTotal());
	            ps.setString(8, "Processing");
	            
	            status = ps.executeUpdate();
	            
	            
	            
	            String query3="select order_id from book_order where order_id=?";
	            PreparedStatement ps3=this.con.prepareStatement(query3);
	            ps3.setInt(1, order.getOrder_id());
	            ResultSet rs3=ps3.executeQuery();
	            int orderId=0;
	            if(rs3.next()) {
	            	orderId = rs3.getInt("order_id");
	            }
	            
	            
	            
	            
	            
	            String query2="insert into order_detail values(?,?,?,?)";
	            PreparedStatement ps2=this.con.prepareStatement(query2);
	            
	            ps2.setInt(1, orderId);
	            ps2.setInt(2, orderDetail.getBook().getB_id());
	            ps2.setInt(3, orderDetail.getQuantity());
	            ps2.setFloat(4, orderDetail.getSubtotal());
	            
	            ps2.executeUpdate();
	            
	             
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
            
            Customer customer=null;
            ResultSet rs2=null;
            while(rs.next())
            {
            	 order =new BookOrder();
            	 order.setOrder_id(rs.getInt("order_id"));
            	 
            	 String query2="select customer_id,fullname from Customer where customer_id=?";
                 PreparedStatement ps2=this.con.prepareStatement(query2);
                 ps2.setInt(1, rs.getInt("customer_id"));
                 rs2=ps2.executeQuery();
               
                 while(rs2.next())
                 {
                 	 customer=new Customer();
                     customer.setCust_id(rs2.getInt("customer_id"));
                     customer.setFullName(rs2.getString("fullname"));
                 }
                 
                 order.setCustomer(customer);
                 order.setOrderDate(rs.getDate("order_date"));
                 order.setShippingAddress(rs.getString("shipping_address"));
                 order.setRecipientName(rs.getString("recipient_name"));
                 order.setRecipientPhone(rs.getString("recipient_phone"));
                 order.setPaymentMethod(rs.getString("payment_method"));
                 order.setTotal(rs.getFloat("total"));
                 order.setStatus(rs.getString("status"));
                
                 orderList.add(order);
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
                 order.setRecipientPhone(rs.getString("recipient_phone"));
                 order.setPaymentMethod(rs.getString("payment_method"));
                 order.setTotal(rs.getFloat("total"));
                 order.setStatus(rs.getString("status"));
                 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
	
	
	public BookOrder getOrderById(int id){
        BookOrder order=null;
        try {
            query="select * from book_order where order_id=?";
            ps=this.con.prepareStatement(query);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next())
            {
            	order=new BookOrder();
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
                 order.setRecipientPhone(rs.getString("recipient_phone"));
                 order.setPaymentMethod(rs.getString("payment_method"));
                 order.setTotal(rs.getFloat("total"));
                 order.setStatus(rs.getString("status"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
   
}
