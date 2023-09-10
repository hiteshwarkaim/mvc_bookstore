package com.bookstore.service;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Book;
import com.bookstore.entities.Category;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


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
        listBooks(null);
    }
     public void listBooks(String message) throws IOException,ServletException{
         List<Book> allBooks = bookDao.listAll();
         request.setAttribute("allBooks", allBooks);
         
         if(message!=null) {
        	 request.setAttribute("message", message);
         }
         
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_list.jsp");
         requestDispatcher.forward(request, response);
     }

     public void showBookForm() throws IOException,ServletException{
  		List<Category> listCategory=categoryDao.getAllCategory();
  		request.setAttribute("listCategory", listCategory);
  		
  		RequestDispatcher rd=request.getRequestDispatcher("book_form.jsp");
  		rd.forward(request, response);
  	} 
     
     public void createBook() throws IOException,ServletException{
         int catId = Integer.parseInt(request.getParameter("category"));

         String title = request.getParameter("title");	
         
         Book existBook = bookDao.findByTitle(title);
         if(existBook!=null) {
        	 String message="Cannot create book with this name "+title+", because this name is already exist";
        	 request.setAttribute("message", message);
        	 listBooks(message);
        	 return;
         }
         
         String author = request.getParameter("author");
         String desc = request.getParameter("desc");
         String isbn = request.getParameter("isbn");
         float price = Float.parseFloat(request.getParameter("price"));
         
         //convert/parse date string data to date object in java
         DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
         Date publishdate=null;
         try {
             publishdate=dateFormat.parse(request.getParameter("publishdate"));
         } catch (ParseException e) {
             e.printStackTrace();
         }
         
        
         Book newBook=new Book();
         newBook.setB_title(title);
         newBook.setAuthor(author);
         newBook.setDesc(desc);
         newBook.setIsbn(isbn);
         newBook.setPublishDate(publishdate);
         
         Category category = categoryDao.getCategoryById(catId);
         newBook.setCategory(category);
         
         newBook.setPrice(price);
         
         
         //fetch image data from form
         Part part=request.getPart("bookimage");
         if(part!=null && part.getSize()>0){
             long size=part.getSize();
             byte[] imageBytes=new byte[(int)size];
             
             InputStream inputStream=part.getInputStream();
             inputStream.read(imageBytes);
             inputStream.close();
         
             newBook.setPic(imageBytes);
         }
         

         int createdBook = bookDao.create(newBook);

         if(createdBook!=0)
         {
             String message="New Book created successfully";
             request.setAttribute("message", message);
             
             listBooks(message);
         }
         else
             System.out.println("error in inserting book");
     }
     
     public void editBook() throws ServletException,IOException{
         
         int id = Integer.parseInt(request.getParameter("id"));
         
         Book bookById = bookDao.getBookById(id);
        
         List<Category> listCategory = categoryDao.getAllCategory();
         
         request.setAttribute("book", bookById);
         request.setAttribute("listCategory", listCategory);
         
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_form.jsp");
         requestDispatcher.forward(request, response);
             
     }
     
     public void updateBook() throws ServletException,IOException{
         System.out.println("update book service");
         int id = Integer.parseInt(request.getParameter("id")); 
         
          String title = request.getParameter("title"); 
         String author = request.getParameter("author");
         String desc = request.getParameter("desc");
         String isbn = request.getParameter("isbn");
         float price = Float.parseFloat(request.getParameter("price"));

     
        DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
        Date publishdate=null;
        try {
            publishdate=dateFormat.parse(request.getParameter("publishdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

          Book existBook = bookDao.getBookById(id);
         Book bookBytitle = bookDao.findByTitle(title);
          
         if(!existBook.equals(bookBytitle)){
             String message="could not update becoz another book has this title "+title;
             
             request.setAttribute("message", message);
             
             listBooks(message);
             return;
             
         }
         System.out.println("id:"+id);
        
        System.out.println("title:"+title);
        System.out.println("author:"+author);
        System.out.println("desc:"+desc);
        System.out.println("isbn:"+isbn);
        System.out.println("price:"+price);
        System.out.println("publishdate:"+publishdate);
       
        Book book=new Book();
        
        book.setB_id(id);
        book.setB_title(title);
        book.setAuthor(author);
        book.setDesc(desc);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setPublishDate(publishdate);
        
        
        int catId = Integer.parseInt(request.getParameter("category"));
        
        Category category = categoryDao.getCategoryById(catId);
        book.setCategory(category);

        System.out.println("reading data");
        Part part=request.getPart("bookimage");
        if(part!=null && part.getSize()>0){
            long size=part.getSize();
            byte[] imageBytes=new byte[(int)size];

            InputStream inputStream=part.getInputStream();
            inputStream.read(imageBytes);
            inputStream.close();

            book.setPic(imageBytes);
        }

         
	     int updateBookDetails = bookDao.update(book);
	     if(updateBookDetails!=0)
	     {
	         System.out.println("book updated");
	         
	         String message="Book updated successfully";
	         request.setAttribute("message", message);
	         listBooks(message);
	     }
	     else{
	         System.out.println("book not updated");
	     }         
         
 }
     
     public void deleteBook() throws IOException,ServletException, SQLException{
         int id = Integer.parseInt(request.getParameter("id"));
         int deleteBook = bookDao.delete(id);
         
         if(deleteBook!=0)
         {
             String message="category deleted successfully";
             request.setAttribute("message", message);
             
             listBooks(message);
         }
        
     }
     
     public void listBooksByCategory() throws IOException,ServletException{
         int id = Integer.parseInt(request.getParameter("id"));
         List<Book> listBookByCategory = bookDao.listBookByCategory(id);
         
         Category category = categoryDao.getCategoryById(id);
         List<Category> allCategory = categoryDao.getAllCategory();
        
         request.setAttribute("listBookByCategory", listBookByCategory);
         request.setAttribute("allCategory", allCategory);
         request.setAttribute("category", category);
             
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("frontend/book_list_by_category.jsp");
         requestDispatcher.forward(request, response);
     }
     
     public void bookDetails() throws IOException,ServletException{
         int id = Integer.parseInt(request.getParameter("id"));
         
         Book book = bookDao.getBookById(id);
         List<Category> allCategory = categoryDao.getAllCategory();
         
         request.setAttribute("book", book);
         request.setAttribute("allCategory", allCategory);
         
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("frontend/book_detail.jsp");
         requestDispatcher.forward(request, response);
         
     }
     
     public void searchBook() throws IOException,ServletException{
         String keyword = request.getParameter("search");
         List<Category> allCategory = categoryDao.getAllCategory();
         
         List<Book> result = null; 
         
         if(keyword.equals("")){
             result=bookDao.listAll();
             String message="Sorry no Result found!!!!!!";
             request.setAttribute("message", message);
             
         }
         else{
             result=bookDao.searchBook(keyword);
             
         }
         request.setAttribute("searchBook", result);
         request.setAttribute("keyword", keyword);
         request.setAttribute("allCategory", allCategory);    
         
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("frontend/search.jsp");
         requestDispatcher.forward(request, response);
         
     }
    
     
}
