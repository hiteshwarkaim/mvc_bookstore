package com.bookstore.frontend.book;

import com.bookstore.service.BookService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewBookServlet", urlPatterns = {"/view-book"})
public class ViewBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        BookService bookService=new BookService(request,response);
        bookService.bookDetails();
    }
}