/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.Book;
import com.bookstore.entities.Category;
import com.bookstore.entities.Customer;
import com.bookstore.entities.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewDao implements GenericDao<Review>{

    private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public ReviewDao(Connection con) {
        this.con=con;
    }

	@Override
	public int create(Review review) {
		int status=0;
        try {
           
            query="insert into Review(book_id, customer_id, rating, headline, comment, review_time) values(?,?,?,?,?,?)";
            ps=this.con.prepareStatement(query);
            
            ps.setObject(1, review.getBook().getB_id());
            ps.setObject(2, review.getCustomer().getCust_id());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getHeadline());
            ps.setString(5, review.getComment());
            ps.setObject(6, new Date());
            status = ps.executeUpdate();
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
        
	}

	@Override
	public int update(Review review) {
		int status=0;
        try {
            query="update Review set headline=?,comment=? where review_id=?";
            ps=this.con.prepareStatement(query);
            
            ps.setString(1, review.getHeadline());
            ps.setString(2,review.getComment());
            ps.setInt(3,review.getReview_id());
            status=ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
		
	}

	@Override
	public int delete(int id) {
		int status=0;
        try {
           
            query="delete from Review where review_id=?";
            ps=this.con.prepareStatement(query);
            ps.setInt(1, id);
            status = ps.executeUpdate();
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
	}

	@Override
	public List<Review> listAll() {
		 List<Review> reviewList=new ArrayList<>();
	        try {
	            query="select * from Review";
	            ps=this.con.prepareStatement(query);
	            
	            rs = ps.executeQuery();
	            
	            while(rs.next()){
	            	Review review=new Review();
	                 
	            	review.setReview_id(rs.getInt("review_id"));
	            	review.setHeadline(rs.getString("headline"));
	            	review.setComment(rs.getString("comment"));
	            	review.setRating(rs.getInt("rating"));
	            	review.setReviewDate(rs.getTimestamp("review_time"));
	            	
	            	int b_id=rs.getInt("book_id");
	            	
	            	String query1="select * from Book where book_id=?";
	                PreparedStatement ps1=con.prepareStatement(query1);
	                ps1.setInt(1, b_id);
	                ResultSet rs1=ps1.executeQuery();
	                while(rs1.next()){
	                    Book b=new Book();
	                    b.setB_title(rs1.getString("title"));
	                    review.setBook(b);
	                }
	                
	                int c_id=rs.getInt("customer_id");
	            	
	            	String query2="select * from Customer where customer_id=?";
	                PreparedStatement ps2=con.prepareStatement(query2);
	                ps2.setInt(1, c_id);
	                ResultSet rs2=ps2.executeQuery();
	                while(rs2.next()){
	                    Customer customer=new Customer();
	                	customer.setFullName(rs2.getString("fullname"));
	                    review.setCustomer(customer);
	                }
	                
	            	
	                reviewList.add(review);
	            }
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return reviewList;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
    
	public Review getReviewById(int id){
        Review review=new Review();
        try {
            query="select * from Review where review_id=?";
            ps=this.con.prepareStatement(query);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next())
            {
            	review.setReview_id(rs.getInt("review_id"));
            	review.setHeadline(rs.getString("headline"));
            	review.setComment(rs.getString("comment"));
            	review.setRating(rs.getInt("rating"));
            	review.setReviewDate(rs.getTimestamp("review_time"));
            	
            	int b_id=rs.getInt("book_id");
            	
            	String query1="select * from Book where book_id=?";
                PreparedStatement ps1=con.prepareStatement(query1);
                ps1.setInt(1, b_id);
                ResultSet rs1=ps1.executeQuery();
                while(rs1.next()){
                    Book b=new Book();
                    b.setB_title(rs1.getString("title"));
                    review.setBook(b);
                }
                
                int c_id=rs.getInt("customer_id");
            	
            	String query2="select * from Customer where customer_id=?";
                PreparedStatement ps2=con.prepareStatement(query2);
                ps2.setInt(1, c_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next()){
                    Customer customer=new Customer();
                	customer.setFullName(rs2.getString("fullname"));
                    review.setCustomer(customer);
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return review;
        }
//    
//	public Review findByCustomerAndBook(int customerId, int bookId) {
//		Review review=new Review();
//        try {
//            query="select * from Review where customer_id=? and book_id=?";
//            ps=this.con.prepareStatement(query);
//            ps.setInt(1,customerId);
//            ps.setInt(2,bookId);
//            rs=ps.executeQuery();
//            while(rs.next())
//            {
//            	review.setReview_id(rs.getInt("review_id"));
//            	review.setHeadline(rs.getString("headline"));
//            	review.setComment(rs.getString("comment"));
//            	review.setRating(rs.getInt("rating"));
//            	review.setReviewDate(rs.getTimestamp("review_time"));
//                
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return review;
//	}
}
