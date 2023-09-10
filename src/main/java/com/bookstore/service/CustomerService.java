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
    
    
    
//    public void getAllUsersData() throws IOException,ServletException{{
//        getAllUsersData(null);
//    }
    
    public void listAllCustomer() throws IOException,ServletException{
        List<Customer> allCustomers = customerDao.listAll();
        request.setAttribute("allCustomers", allCustomers);

                    
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer_list.jsp");
        requestDispatcher.forward(request, response);
    } 
    
    

}