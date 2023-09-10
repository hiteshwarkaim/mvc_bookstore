/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.CustomerDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Customer;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerService {

    private CustomerDao customerDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    public CustomerService(HttpServletRequest request,HttpServletResponse response) {
        this.request=request;
        this.response=response;
        customerDao=new CustomerDao(DB_Connection.getConnection());
    }
    
    
    
    public void listAllCustomer() throws IOException,ServletException{
        listAllCustomer(null);
    }
    
    public void listAllCustomer(String message) throws IOException,ServletException{
        List<Customer> allCustomers = customerDao.listAll();
        if(message!=null)
        	request.setAttribute("message", message);
        
        request.setAttribute("allCustomers", allCustomers);
             
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer_list.jsp");
        requestDispatcher.forward(request, response);
    } 
    
    public void createCustomer() throws ServletException,IOException{
        
        int status=0;
        Customer newCustomer=null;
        
        
        String email=request.getParameter("email");
        String fullname=request.getParameter("fullname");
        String pwd1=request.getParameter("pwd1");
        String pwd2=request.getParameter("pwd2");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        String city=request.getParameter("city");
        String zipcode=request.getParameter("zipcode");
        String country=request.getParameter("country");
        Date register=new Date();
        
	    //fetch  the user with this email
	    Customer customerByEmail = customerDao.getCustomerByEmail(email);
        
        //check email is already exist or not
        if(customerByEmail!=null){
            System.out.println("exist krti hai ye");
            
            String message="email already exist: "+email;
            request.setAttribute("message", message);
            
            listAllCustomer(message);
        }
        else{
            
            //if email is not already exist, then insert the data
            newCustomer=new Customer(email, fullname, address, city, country, phone, zipcode,pwd1, register);
            customerDao.create(newCustomer);
            
            String message="customer is created successfully: "+newCustomer.getFullName();
            request.setAttribute("message", message);
            
            listAllCustomer(message);        
            }
               
        }
         
} 
    
    

