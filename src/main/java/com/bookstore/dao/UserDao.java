/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements GenericDao<User>{

    private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public UserDao(Connection con) {
        this.con=con;
    }
    
    @Override
    public List<User> listAll(){
        List<User> usersList=new ArrayList<>();
        try {
            query="select * from users";
            ps=this.con.prepareStatement(query);
            
            rs = ps.executeQuery();
          
            while(rs.next()){
                 User user=new User();
                 
                 user.setId(rs.getInt("user_id"));
                 user.setName(rs.getString("full_name"));
                 user.setEmail(rs.getString("email"));
                 
                 usersList.add(user);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

	@Override
	public int create(User user) {
		int status=0;
        try {
           
            query="insert into users(full_name,email,password) values(?,?,?)";
            ps=this.con.prepareStatement(query);
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            status = ps.executeUpdate();
            System.out.println(status);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	public User getById(int id) {
		 User user=new User();
         try {
             query="select * from users where user_id=?";
             ps=this.con.prepareStatement(query);
             ps.setInt(1,id);
             rs=ps.executeQuery();
             while(rs.next())
             {
                 user.setId(rs.getInt("user_id"));
                 user.setName(rs.getString("full_name"));
                 user.setEmail(rs.getString("email"));
                 user.setPassword(rs.getString("password"));
                 
                 return user;
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         return user;
	}
	
	public User getByEmail(String email) {
		User user=null;
        try {
            query="select * from users where email=?";
            ps=this.con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
             while(rs.next()){
                user=new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  user;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	
 }
