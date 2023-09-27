package com.bookstore.controller.admin.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Book;
import com.bookstore.service.CustomerService;
import com.bookstore.service.OrderService;
import com.bookstore.service.UserService;

@WebServlet(name = "ShowAddBookFormServlet", urlPatterns = {"/admin/add-book-form"})
public class ShowAddBookFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	BookDao bookDao=new BookDao(DB_Connection.getConnection());
        	List<Book> listAll = bookDao.listAll();
        	request.setAttribute("listAll", listAll);
        	
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("add_book_form.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
