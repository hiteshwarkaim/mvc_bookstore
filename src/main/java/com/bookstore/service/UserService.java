/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.DB_Connection;
import com.bookstore.dao.UserDao;
import com.bookstore.entities.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserService {

    private UserDao userDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    public UserService(HttpServletRequest request,HttpServletResponse response) {
        this.request=request;
        this.response=response;
        userDao=new UserDao(DB_Connection.getConnection());
    }
    
    
    public void getAllUsers() throws IOException,ServletException{
        List<User> allUsers = userDao.listAll();
        request.setAttribute("allUsers", allUsers);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user_list.jsp");
        requestDispatcher.forward(request, response);

    }
}
