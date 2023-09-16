/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.dao.ReviewDao;
import com.bookstore.entities.Book;
import com.bookstore.entities.Category;
import com.bookstore.entities.Review;

public class ReviewService {

    private ReviewDao reviewDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    public ReviewService(HttpServletRequest request,HttpServletResponse response) {
        this.request=request;
        this.response=response;
        reviewDao=new ReviewDao(DB_Connection.getConnection());
    }
    
    
    
    public void getAllReview() throws IOException,ServletException{
    	getAllReview(null);
    }
    
    public void getAllReview(String message) throws IOException,ServletException{
        List<Review> allReview = reviewDao.listAll();
        request.setAttribute("allReview", allReview);
        
        
        if(message!=null)
        	request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("review_list.jsp");
        requestDispatcher.forward(request, response);

    }
      
//    public void createCategory() throws ServletException,IOException{
//        
//        int status=0;
//        Category newCategory=null;
//        
//        String name=request.getParameter("name");
//        
//        //fetch  the category with this name
//        Category categoryByName = categoryDao.getCategoryByName(name);
//        
//        
//        //check name is already exist or not
//        if(categoryByName!=null){
//            System.out.println("exist krti hai ye");
//            
//            String message="category name already exist: "+name;
//            request.setAttribute("message", message);
//            
//            RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
//            rd.forward(request, response);
//        }
//        else{
//            
//            //if email is not already exist, then insert the data
//            newCategory=new Category(name);
//            status = categoryDao.create(newCategory);
//            getAllCategory("category is created successfully: "+newCategory.getName());
//            
//        }
//         
//} 
//
    public void editReview() throws ServletException,IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Review reviewById = reviewDao.getReviewById(id);
        request.setAttribute("review", reviewById);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("review_form.jsp");
        requestDispatcher.forward(request, response);
            
    }
//    
//    public void updateCategory() throws ServletException,IOException{
//        
//        int id = Integer.parseInt(request.getParameter("id"));
//        
//        String name=request.getParameter("name");
//        
//	    Category categoryById = categoryDao.getCategoryById(id);
//	    Category categoryByName = categoryDao.getCategoryByName(name);
//        
//	    if(categoryByName!=null && categoryByName.getCat_id()!=categoryById.getCat_id())
//        {
//            System.out.println("could not update");
//            String message="could not update "+name+" already exist";
//            request.setAttribute("message", message);
//            
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
//            requestDispatcher.forward(request, response);
//            
//        }
//        else{
//            Category category=new Category(id,name);
//            int updateCategoryDetails = categoryDao.update(category);
//            getAllCategory("Category updated successfully"); 
//        }
//    }
//    
//    public void removeCategory() throws IOException,ServletException, SQLException{
//        int id = Integer.parseInt(request.getParameter("id"));
//        int deleteCategory = categoryDao.delete(id);
//        
//        long numberOfBooks = bookDao.countByCategory(id);
//        System.out.println(numberOfBooks);
//        String message;
//        
//        if(numberOfBooks>0) {
//        	message="Could not delete this category, because it contains some(%d) books";
//        	message=String.format(message, numberOfBooks);
//        }
//        else
//        {
//            message="category deleted successfully";
//        }
//        request.setAttribute("message", message);
//        
//        getAllCategory(message);
//    }


}