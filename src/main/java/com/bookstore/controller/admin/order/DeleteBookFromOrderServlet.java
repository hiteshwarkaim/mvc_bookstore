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

@WebServlet(name = "DeleteBookFromOrderServlet", urlPatterns = {"/admin/remove-book-from-order"})
public class DeleteBookFromOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	int bookId=Integer.parseInt(request.getParameter("id"));
        	
        	BookOrder order =	(BookOrder)request.getSession().getAttribute("order");
        
        	OrderDetailDao orderDetailDao=new OrderDetailDao(DB_Connection.getConnection());
        	Set<OrderDetail> orderDetails = order.getOrderDetails();
        	Iterator<OrderDetail> iterator=orderDetails.iterator();
        	
        	while(iterator.hasNext()) {
        		OrderDetail orderDetail=iterator.next();
        		
        		if(orderDetail.getBook().getB_id()==bookId) {
        			
        			float newTotal=order.getTotal()-orderDetail.getSubtotal();
        			order.setTotal(newTotal);
        			orderDetailDao.delete(bookId);
        		}
        	}
        	
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("order_form.jsp");
            requestDispatcher.forward(request, response);
        }
        
    }
}
