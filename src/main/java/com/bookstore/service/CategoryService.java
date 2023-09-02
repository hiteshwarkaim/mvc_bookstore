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
    
    
    public void createCategory() throws ServletException,IOException{
        
        int status=0;
        Category newCategory=null;
        
        String name=request.getParameter("name");
        
    //fetch  the category with this name
        Category categoryByName = categoryDao.getCategoryByName(name);
        
        
        //check name is already exist or not
        if(categoryByName!=null){
            System.out.println("exist krti hai ye");
            
            String message="category name already exist: "+name;
            request.setAttribute("message", message);
            
            RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
        }
        else{
            
            //if email is not already exist, then insert the data
            newCategory=new Category(name);
            status = categoryDao.create(newCategory);
            getAllCategory("category is created successfully: "+newCategory.getName());
            
        }
         
} 

    
    

    
 
   
    
}
