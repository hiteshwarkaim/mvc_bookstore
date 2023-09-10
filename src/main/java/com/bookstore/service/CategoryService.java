/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class CategoryService {

    private CategoryDao categoryDao;
    private BookDao bookDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    public CategoryService(HttpServletRequest request,HttpServletResponse response) {
        this.request=request;
        this.response=response;
        categoryDao=new CategoryDao(DB_Connection.getConnection());
        bookDao=new BookDao(DB_Connection.getConnection());
    }
    
    
    
    public void getAllCategory() throws IOException,ServletException{
    	getAllCategory(null);
    }
    
    public void getAllCategory(String message) throws IOException,ServletException{
        List<Category> allCategory = categoryDao.getAllCategory();
        request.setAttribute("allCategory", allCategory);
        
        
        if(message!=null)
        	request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category_list.jsp");
        requestDispatcher.forward(request, response);

    }
      
    public void createCategory() throws ServletException,IOException{
        
        int status=0;
        Category newCategory=null;
        
        String name=request.getParameter("name");
        
        //fetch  the category with this name
        Category categoryByName = categoryDao.getCategoryByName(name);
        
        
        //check name is already exist or not
        if(categoryByName!=null){
            System.out.println("exist krti hai ye");
            
            String message="category name already exist: "+name;
            request.setAttribute("message", message);
            
            RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
        }
        else{
            
            //if email is not already exist, then insert the data
            newCategory=new Category(name);
            status = categoryDao.create(newCategory);
            getAllCategory("category is created successfully: "+newCategory.getName());
            
        }
         
} 

    public void editCategory() throws ServletException,IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Category getCategoryById = categoryDao.getCategoryById(id);
        request.setAttribute("category", getCategoryById);
        System.out.println(getCategoryById);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category_form.jsp");
        requestDispatcher.forward(request, response);
            
    }
    
    public void updateCategory() throws ServletException,IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        String name=request.getParameter("name");
        
	    Category categoryById = categoryDao.getCategoryById(id);
	    Category categoryByName = categoryDao.getCategoryByName(name);
        
	    if(categoryByName!=null && categoryByName.getCat_id()!=categoryById.getCat_id())
        {
            System.out.println("could not update");
            String message="could not update "+name+" already exist";
            request.setAttribute("message", message);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request, response);
            
        }
        else{
            Category category=new Category(id,name);
            int updateCategoryDetails = categoryDao.update(category);
            getAllCategory("Category updated successfully"); 
        }
    }
    
    public void removeCategory() throws IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        int deleteCategory = categoryDao.delete(id);
        
        if(deleteCategory!=0)
        {
            String message="category deleted successfully";
            request.setAttribute("message", message);
            
            getAllCategory(message);
            
        }
    }

    public void listByBooksByCategory() throws IOException,ServletException{
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
}