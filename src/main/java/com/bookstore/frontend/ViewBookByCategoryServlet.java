//package com.bookstore.frontend;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.bookstore.service.BookService;
//
//@WebServlet(name = "ViewBookByCategoryServlet", urlPatterns = {"/view-category"})
//public class ViewBookByCategoryServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public ViewBookByCategoryServlet() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		BookService service=new BookService(request, response);
//		service.listBooksByCategory();
//	}
//	
//}
