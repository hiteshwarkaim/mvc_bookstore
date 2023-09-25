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

public class OrderDetailDao implements GenericDao<OrderDetail>{

    private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public OrderDetailDao(Connection con) {
        this.con=con;
    }
    
    public OrderDetailDao() {
    }

    @Override
	public int create(OrderDetail orderDetail) {
		 int status=0;
		 
	        try {
	           
	        	String query="insert into order_detail values(?,?,?,?)";
	            PreparedStatement ps=this.con.prepareStatement(query);
	           
	            
	            System.out.println("orderid "+orderDetail.getOrder_id());
	            System.out.println("bookid " +orderDetail.getBook().getB_id());
	            System.out.println("qty "+orderDetail.getQuantity());
	            System.out.println("subtotal "+orderDetail.getSubtotal());
	            
	            ps.setInt(1, orderDetail.getOrder_id());
	            
	            ps.setInt(2, orderDetail.getBook().getB_id());
	            ps.setInt(3, orderDetail.getQuantity());
	            ps.setFloat(4, orderDetail.getSubtotal());
	            
	            ps.executeUpdate();
	            
	            
	            
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return status;
		
	}

	

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderDetail> listAll() {
		return null;
//		List<OrderDetail> orderList=new ArrayList<>();
//        BookOrder order=null;
//        try {
//            query="select * from book_order";
//            ps=this.con.prepareStatement(query);
//            rs = ps.executeQuery();
//            
//            Customer customer=null;
//            ResultSet rs2=null;
//            while(rs.next())
//            {
//            	 order =new BookOrder();
//            	 order.setOrder_id(rs.getInt("order_id"));
//            	 
//            	 String query2="select * from Customer where customer_id=?";
//                 PreparedStatement ps2=this.con.prepareStatement(query2);
//                 ps2.setInt(1, rs.getInt("customer_id"));
//                 rs2=ps2.executeQuery();
//               
//                 while(rs2.next())
//                 {
//                 	 customer=new Customer();
//                     customer.setCust_id(rs2.getInt("customer_id"));
//                     customer.setFullName(rs2.getString("fullname"));
//                 }
//                 
//                 order.setCustomer(customer);
//                 order.setOrderDate(rs.getDate("order_date"));
//                 order.setShippingAddress(rs.getString("shipping_address"));
//                 order.setRecipientName(rs.getString("recipient_name"));
//                 order.setRecipientPhone(rs.getString("recipient_phone"));
//                 order.setPaymentMethod(rs.getString("payment_method"));
//                 order.setTotal(rs.getFloat("total"));
//                 order.setStatus(rs.getString("status"));
//                
//                 orderList.add(order);
//            }     
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return orderList;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OrderDetail t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	public BookOrder getBookOrderById(int id){
//        BookOrder order=new BookOrder();
//        try {
//            query="select * from book_order where order_id=?";
//            ps=this.con.prepareStatement(query);
//            ps.setInt(1,id);
//            rs=ps.executeQuery();
//            while(rs.next())
//            {
//            	 order.setOrder_id(rs.getInt("order_id"));
//            	 
//            	 String query2="select * from Customer where customer_id=?";
//                 PreparedStatement ps2=this.con.prepareStatement(query2);
//                 ps2.setInt(1, rs.getInt("customer_id"));
//                 ResultSet rs2=ps2.executeQuery();
//                 Customer customer=null;
//                 if(rs2.next())
//                 {
//                 	customer=new Customer();
//                     customer.setCust_id(rs2.getInt("customer_id"));
//                     customer.setFullName(rs2.getString("fullname"));
//                 }
//                 
//                 order.setCustomer(customer);
//                 order.setOrderDate(rs.getDate("order_date"));
//                 order.setShippingAddress(rs.getString("shipping_address"));
//                 order.setRecipientName(rs.getString("recipient_name"));
//                 order.setRecipientPhone(rs.getString("recipient_phone"));
//                 order.setPaymentMethod(rs.getString("payment_method"));
//                 order.setTotal(rs.getFloat("total"));
//                 order.setStatus(rs.getString("status"));
//                 
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return order;
//    }
//	
//	
	public List<OrderDetail> getOrderDetailById(int id){
		List<OrderDetail> orderDetailList=new ArrayList<OrderDetail>();
        OrderDetail orderDetail=null;
		try {
            query="select * from order_detail where order_id=?";
            ps=this.con.prepareStatement(query);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            
            int orderId=0;
            int bookId=0;
            int qty=0;
            int subtotal=0;
            while(rs.next())
            {
            	orderDetail=new OrderDetail();
            	 
            	orderId=rs.getInt("order_id");
            	bookId=rs.getInt("book_id");
            	qty=rs.getInt("quantity");
            	subtotal=rs.getInt("subtotal");
            	
            	
            	
            	
            	
            	orderDetail.setOrder_id(orderId);
            	
            	
            	
            	
            	String query1 ="select * from Book where book_id=?";
            	PreparedStatement ps1=this.con.prepareStatement(query1);
              	ps1.setInt(1,bookId);
              	ResultSet rs1=ps1.executeQuery();
          		Book book=null;
            	if(rs1.next()) {
            		book=new Book();
            		book.setB_id(bookId);
            		book.setB_title(rs1.getString("title"));
            		book.setAuthor(rs1.getString("author"));
            		book.setPrice(rs1.getFloat("price"));
            		

//                  //fetch image
                 try {
                      Blob b=rs1.getBlob("image");
                     byte[] barr=b.getBytes(1, (int) b.length());
                     Path path = Paths.get("D:/xtra/");
                     File file = new File("D:/xtra/"+ path.getFileName());
                     OutputStream fos=new FileOutputStream(file);
                     fos.write(barr);
                     fos.flush();
                     fos.close();
               } catch (FileNotFoundException e) {
                     e.printStackTrace();
                 }
                  
               
                  book.setPic(rs1.getBytes("image"));
            	}
          		
          		orderDetail.setBook(book);
            	
          		
          		
          		
          		
          		
          		
          		
          		String query2 ="select * from Book_order where order_id=?";
            	PreparedStatement ps2=this.con.prepareStatement(query2);
              	ps2.setInt(1,orderId);
              	ResultSet rs2=ps2.executeQuery();
          		BookOrder bookOrder=null;
            	if(rs2.next()) {
            		bookOrder=new BookOrder();
            		bookOrder.setOrder_id(orderId);
            	}
          		
          		orderDetail.setBookOrder(bookOrder);
            	
          		
          		
          		
          		
          		
          		orderDetail.setQuantity(qty);
          		orderDetail.setSubtotal(subtotal);
          		
          		orderDetailList.add(orderDetail);
//                 
//            	orderDetail.setOrder_id(rs.getInt("order_id"));//get order_id and set order_id
//            	
//            	
//            	String query1 ="select * from Book where book_id=?";
//                PreparedStatement ps1=this.con.prepareStatement(query1);
//                ps1.setInt(1,id);
//                ResultSet rs1=ps1.executeQuery();
//            	Book book=null;
//                if(rs1.next())
//            	{
//            		book=new Book();
//            		book.setB_id(rs.getInt("book_id"));
//            	}
//            	orderDetail.setBook(book);
//            	
//
//            	String query2 ="select * from Book where book_id=?";
//                PreparedStatement ps2=this.con.prepareStatement(query2);
//                ps2.setInt(1,id);
//                ResultSet rs2=ps2.executeQuery();
//            	BookOrder bookOrder=null;
//                if(rs1.next())
//            	{
//            		bookOrder=new BookOrder();
//            		bookOrder.se
//            	}
//                
//            	orderDetail.setBookOrder(null);;
//            	orderDetail.setOrder_id(rs.getInt("order_id"));
            	
            	
            	
            	
            	
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetailList;
    }
	
	
	
   
}
