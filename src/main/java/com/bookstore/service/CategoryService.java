/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Category;

public class CategoryService {

    private CategoryDao categoryDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    public CategoryService(HttpServletRequest request,HttpServletResponse response) {
        this.request=request;
        this.response=response;
        categoryDao=new CategoryDao(DB_Connection.getConnection());
    }
    
    
    
    public void getAllCategory() throws IOException,ServletException{
    	getAllCategory(null);
    }
    
    public void getAllCategory(String message) throws IOException,ServletException{
        List<Category> allCategory = categoryDao.getAllCategory();
        request.setAttribute("allCategory", allCategory);
        
        if(message!=null)
        	request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category_list.jsp");
        requestDispatcher.forward(request, response);

    }
    
    
    

    
 
   
    
}
