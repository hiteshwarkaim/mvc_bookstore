package com.bookstore.controller.admin.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.DB_Connection;
import com.bookstore.dao.OrderDetailDao;
import com.bookstore.entities.BookOrder;
import com.bookstore.entities.OrderDetail;
import com.bookstore.service.CustomerService;
import com.bookstore.service.OrderService;
import com.bookstore.service.UserService;

@WebServlet(name = "DeleteOrderServlet", urlPatterns = {"/admin/delete-order"})
public class DeleteOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	OrderService service=new OrderService(request, response);
        	service.deleteOrderAdmin();
        }
        
    }
}
