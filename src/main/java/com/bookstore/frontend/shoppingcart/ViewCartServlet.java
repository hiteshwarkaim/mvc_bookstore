/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend.shoppingcart;


import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Book;
import com.bookstore.entities.Category;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewCartServlet", urlPatterns = {"/view-cart"})
public class ViewCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Object cartObject=request.getSession().getAttribute("cart");
        
        if(cartObject==null) {
        	ShoppingCart shoppingCart=new ShoppingCart();
        	request.getSession().setAttribute("cart", shoppingCart);
        }
        
//        Book book=new Book();
//        book.setB_title("maths");
//        book.setPrice(20);
        
        BookDao bookDao=new BookDao(DB_Connection.getConnection());
        Book book1 = bookDao.getBookById(10);
        Book book2 = bookDao.getBookById(5);
        Book book3 = bookDao.getBookById(7);
        
        ShoppingCart cartSession=(ShoppingCart)request.getSession().getAttribute("cart");
        cartSession.addItem(book3);
        cartSession.addItem(book3);
        cartSession.addItem(book2);
        cartSession.addItem(book3);
        
        RequestDispatcher rd = request.getRequestDispatcher("frontend/shopping_cart.jsp");
        rd.forward(request, response);
    }
}
