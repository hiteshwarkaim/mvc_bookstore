package com.bookstore.controller.admin.category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.CategoryService;
import com.bookstore.service.UserService;

@WebServlet(name = "ListCategoryServlet", urlPatterns = {"/admin/list-category"})
public class ListCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	
            CategoryService service=new CategoryService(request,response);
            service.getAllCategory();            
            
        }
    }
}
