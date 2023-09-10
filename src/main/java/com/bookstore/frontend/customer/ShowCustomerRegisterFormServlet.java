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

@WebServlet(name = "ShowCustomerRegisterFormServlet", urlPatterns = {"/register"})
public class ShowCustomerRegisterFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("frontend/register_form.jsp");
            requestDispatcher.forward(request, response);
            
        }
    }
}
