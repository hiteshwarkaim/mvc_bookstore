/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend.customer;

import java.io.IOException;
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

@WebFilter(filterName = "CustomerLoginFilter", urlPatterns = {"/*"}) //* means it intercept all request came after admin URL
public class CustomerLoginFilter implements Filter {
    
	private static final String[] requiredURLs= { "/view_profile","/edit_profile","/update_profile","/write-review","/checkout","/place-order","/view-order","/show-order-detail"};
    private FilterConfig filterConfig = null;
    
    public CustomerLoginFilter() {
    }    
    
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
        
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpSession session=httpRequest.getSession(false); //get session object, don't create new session if session does't exist
        
        String path=httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        
        if(path.startsWith("/admin/")) {
        	chain.doFilter(	request, response);
        	return;
        }
        
        boolean loggedIn= (session!=null) && (session.getAttribute("loggedCustomer")!=null);
        
        String requestURL=httpRequest.getRequestURI().toString();
        
        if(!loggedIn && isLoginRequired(requestURL))
        {
            RequestDispatcher rd = request.getRequestDispatcher("frontend/login.jsp");
            rd.forward(request, response);
        }
        else
        {
            System.out.println("login failed...............");
            chain.doFilter(request, response);
        }
    }

    private boolean isLoginRequired(String requestURL) {
    	for(String loginRequiredURL:requiredURLs) {
    		if(requestURL.contains(loginRequiredURL)) {
    			return true;
    		}
    	}
    	return false;
    }
    public void destroy() {        
    
    }

   
    
    
}
