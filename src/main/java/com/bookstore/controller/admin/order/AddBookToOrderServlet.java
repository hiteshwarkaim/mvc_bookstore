package com.bookstore.controller.admin.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.dao.OrderDetailDao;
import com.bookstore.entities.Book;
import com.bookstore.entities.BookOrder;
import com.bookstore.entities.OrderDetail;
import com.bookstore.service.CustomerService;
import com.bookstore.service.OrderService;
import com.bookstore.service.UserService;

@WebServlet(name = "AddBookToOrderServlet", urlPatterns = {"/admin/add-book-to-order"})
public class AddBookToOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	int bookId = Integer.parseInt(request.getParameter("bookId"));
        	int quantity = Integer.parseInt(request.getParameter("quantity"));
            
        	BookDao bookDao=new BookDao(DB_Connection.getConnection());
        	Book book = bookDao.getBookById(bookId);
        	
        	BookOrder order = (BookOrder)request.getSession().getAttribute("order");
        	
        	float subtotal=quantity*book.getPrice();
        	
        	
        	
        	OrderDetail orderDetail=new OrderDetail();
        	
        	orderDetail.setOrder_id(order.getOrder_id());
        	orderDetail.setBookOrder(order);
        	orderDetail.setBook(book);
        	orderDetail.setQuantity(quantity);
        	orderDetail.setSubtotal(subtotal);
        	
        	float newTotal=order.getTotal()+subtotal;
        	order.setTotal(newTotal);
        	
        	request.setAttribute("book", book);
        	request.getSession().setAttribute("NewBookPendingToAddToOrder", true);
        	
        	OrderDetailDao orderDetailDao=new OrderDetailDao(DB_Connection.getConnection());System.out.println(order.getOrder_id());
        	int update = orderDetailDao.create(orderDetail,order.getOrder_id());
        	System.out.println(update);
        	
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("add_book_result.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
