/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CategoryDao(Connection con) {
        this.con=con;
    }
  
    
    public List<Category> getAllCategory(){
        List<Category> categoryList=new ArrayList<>();
        try {
            query="select * from category";
            ps=this.con.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                 Category cat=new Category();
                 
                 cat.setCat_id(rs.getInt("category_id"));
                 cat.setName(rs.getString("category_name"));
                 
                 categoryList.add(cat);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;
    }
    
    
   
        
         

   
}
