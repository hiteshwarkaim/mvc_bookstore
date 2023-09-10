/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.Customer;
import com.bookstore.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


	public class CustomerDao implements GenericDao<Customer> {

	    private Connection con=null;
	    private String query;
	    private PreparedStatement ps;
	    private ResultSet rs;
	    
	    public CustomerDao(Connection con) {
	        this.con=con;
	    }
	    
	    @Override
	    public List<Customer> listAll(){
	        List<Customer> customersList=new ArrayList<>();
	        try {
	            query="select * from customer";
	            ps=this.con.prepareStatement(query);
	            
	            rs = ps.executeQuery();
	            
	            while(rs.next()){
	                 Customer customer=new Customer();
	                 
	                 customer.setCust_id(rs.getInt("customer_id"));
	                 customer.setEmail(rs.getString("email"));
	                 customer.setFullName(rs.getString("fullname"));
	                 customer.setAddress(rs.getString("address"));
	                 customer.setCity(rs.getString("city"));
	                 customer.setCountry(rs.getString("country"));
	                 customer.setPhone(rs.getString("phone"));
	                 customer.setZipcode(rs.getString("zipcode"));
	                 customer.setRegister(rs.getDate("register_date"));
	                 
	                 customersList.add(customer);
	            }
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return customersList;
	    }
	    


			@Override
			public long count() {
				// TODO Auto-generated method stub
				return 0;
			}

	}