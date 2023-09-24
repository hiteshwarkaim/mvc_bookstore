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
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateCartServlet", urlPatterns = {"/update-cart"})
public class UpdateCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String[] arrayBookIds=request.getParameterValues("bookId");
        String[] arrayQuantities=new String[arrayBookIds.length];
        
        for (int i = 1; i <= arrayQuantities.length; i++) {
			String aQuantity=request.getParameter("quantity"+i);
			arrayQuantities[i-1]=aQuantity;
		}

//        response.getWriter().println(arrayBookIds);
//        response.getWriter().println(arrayQuantities);
        
//        response.getWriter().println(Arrays.asList(arrayBookIds));
//        response.getWriter().println(Arrays.asList(arrayQuantities));
        
        
        int[] bookIds = Arrays.stream(arrayBookIds).mapToInt(Integer::parseInt).toArray();
        int[] quantities = Arrays.stream(arrayQuantities).mapToInt(Integer::parseInt).toArray();
        
        ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
        cart.updateCart(bookIds, quantities);
        
        String  cartPage=request.getContextPath().concat("/view-cart");
        response.sendRedirect(cartPage);
    }
}
