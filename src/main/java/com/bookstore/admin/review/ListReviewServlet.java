package com.bookstore.admin.review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.CustomerService;
import com.bookstore.service.ReviewService;
import com.bookstore.service.UserService;

@WebServlet(name = "ListReviewServlet", urlPatterns = {"/admin/list-reviews"})
public class ListReviewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	
            ReviewService service=new ReviewService(request,response);
            service.getAllReview();
            
        }
    }
}
