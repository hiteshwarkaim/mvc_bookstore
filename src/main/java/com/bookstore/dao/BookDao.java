package com.bookstore.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bookstore.entities.Book;
import com.bookstore.entities.Category;

public class BookDao implements GenericDao<Book>{

	private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
	
	public BookDao(Connection con) {
        this.con=con;
    }
	
	@Override
	public int create(Book book) {
		return 0;
	}

	@Override
	public int update(Book t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Book> listAll() {
		List<Book> booksList=new ArrayList<>();
        Book book=null;
        try {
            query="select * from book";
            ps=this.con.prepareStatement(query);
            rs = ps.executeQuery();
            
            ResultSet rs1=null;
            Category cat=null;
            while(rs.next()){
//               
                 book=new Book();
                 
                 book.setB_id(rs.getInt("book_id"));
                 book.setB_title(rs.getString("title"));
                 book.setAuthor(rs.getString("author"));
                 book.setDesc(rs.getString("description"));
                 book.setIsbn(rs.getString("isbn"));
    
//                 //fetch image
                try {
                     Blob b=rs.getBlob("image");
                    byte[] barr=b.getBytes(1, (int) b.length());
                    Path path = Paths.get("D:/xtra/");
                    File file = new File("D:/xtra/"+ path.getFileName());
//                    if(!file.canRead())
//                    file.setReadable(true);
                    OutputStream fos=new FileOutputStream(file);
                    fos.write(barr);
                    fos.flush();
                    fos.close();
//                    book.setPic(barr);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//                 
              
                 book.setPic(rs.getBytes("image"));
                 book.setPrice(rs.getFloat("price"));
                 book.setPublishDate(rs.getDate("publish_date"));
                 book.setLastUpdateTime(rs.getTimestamp("last_update_time"));
               
                 int catid=rs.getInt("category_id");
                 
                String query1="select category_name from category where category_id=?";
                PreparedStatement ps1=con.prepareStatement(query1);
                ps1.setInt(1, catid);
                rs1=ps1.executeQuery();
                while(rs1.next()){
                    cat=new Category();
                    cat.setName(rs1.getString("category_name"));
                    book.setCategory(cat);
                }
                booksList.add(book);
            }           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}