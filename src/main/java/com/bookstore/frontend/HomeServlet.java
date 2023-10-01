/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend;


import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.dao.ReviewDao;
import com.bookstore.entities.Book;
import com.bookstore.entities.Category;
import com.bookstore.entities.Review;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

@WebServlet(name = "HomeServlet", urlPatterns = {""})
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        BookDao bookDao=new BookDao(DB_Connection.getConnection());
        
        List<Book> listNewBook = bookDao.listNewBook();;
        request.setAttribute("listNewBook", listNewBook);
        
        
//        ReviewDao reviewDao=new ReviewDao(DB_Connection.getConnection());
//        Set<Integer> allReviewIds = reviewDao.getAllReviewIntegersIds();
//        
//        List<Integer> allRating = reviewDao.getAllRating();
//        int sum=0;
//        for (int i = 0; i <allRating.size(); i++) {
//			sum+=allRating.get(i);
//		}
//        
//        int avgRating=sum/allRating.size();
        
        
        List<Integer> ids = bookDao.listBestSellingBookIds();
        
        List<Book> listBestSellingBook = bookDao.listBestSellingBook(ids);
        request.setAttribute("listBestSellingBook", listBestSellingBook);
        
        RequestDispatcher rd = request.getRequestDispatcher("frontend/index.jsp");
        rd.forward(request, response);
    }
}
