package com.bookstore.frontend.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.CustomerService;
import com.bookstore.service.UserService;

@WebServlet(name = "EditCustomerProfileServlet", urlPatterns = {"/edit-profile"})
public class EditCustomerProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	CustomerService service=new CustomerService(request,response);
        	service.showCustomerEditForm();
            
        }
    }
}
