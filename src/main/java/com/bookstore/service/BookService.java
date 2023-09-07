package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Book;
import com.bookstore.entities.Category;

public class BookService {
	private BookDao bookDao;
    private CategoryDao categoryDao;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public BookService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        bookDao=new BookDao(DB_Connection.getConnection());
       categoryDao=new CategoryDao(DB_Connection.getConnection());
        
    }
  
     public void listBooks() throws IOException,ServletException{
        List<Book> allBooks = bookDao.listAll();
        request.setAttribute("allBooks", allBooks);
              
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_list.jsp");
        requestDispatcher.forward(request, response);
    }

	public void showBookForm() throws IOException,ServletException{
		List<Category> listCategory=categoryDao.getAllCategory();
		request.setAttribute("listCategory", listCategory);
		
		RequestDispatcher rd=request.getRequestDispatcher("book_form.jsp");
		rd.forward(request, response);
	} 
     
    
}
