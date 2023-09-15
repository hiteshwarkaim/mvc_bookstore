/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Category;

@WebFilter(filterName = "CommonFilter", urlPatterns = {"/*"}) //* means it intercept all request came after admin URL
public class CommonFilter implements Filter {
    

    private FilterConfig filterConfig = null;
    private final CategoryDao categoryDao;
    
    public CommonFilter() {
    	categoryDao=new CategoryDao(DB_Connection.getConnection());
    }    
    
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
    	HttpServletRequest httpRequest=(HttpServletRequest)request;
    	String path=httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
    	
    	if(!path.startsWith("/admin/")) {
    		List<Category> allCategory=categoryDao.getAllCategory();
      		request.setAttribute("allCategory", allCategory);	
      		
      		System.out.println("common filter-> doFilter");
    	}
    	
    	chain.doFilter(request, response);
 
  		
    }

    public void destroy() {        
    
    }

   
    
    
}
