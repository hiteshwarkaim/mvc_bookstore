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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bookstore.entities.Book;
import com.bookstore.entities.BookOrder;
import com.bookstore.entities.Category;
import com.bookstore.entities.OrderDetail;
import com.bookstore.entities.Review;

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
		 int status=0;
	        try {
	           
	            query="insert into book(title,author,description,isbn,image,price,publish_date,last_update_time,category_id) values(?,?,?,?,?,?,?,?,?)";
	            ps=this.con.prepareStatement(query);
	            
	            ps.setString(1, book.getB_title());
	            ps.setString(2, book.getAuthor());
	            ps.setString(3, book.getDesc());
	            ps.setString(4, book.getIsbn());
	            ps.setBytes(5, book.getPic());
	            ps.setFloat(6, book.getPrice());
	            ps.setObject(7, book.getPublishDate());
	            ps.setObject(8, new Date());
	            
	            //fetch category name by categori id
	            String query1="select * from category where category_name=?";
	            PreparedStatement ps1=this.con.prepareStatement(query1);
	            ps1.setString(1, book.getCategory().getName());
	            ResultSet rs1=ps1.executeQuery();
	            Category category=null;
	            
	            if(rs1.next()){
	                category=new Category();
	                int catid=rs1.getInt("category_id");
	                category.setCat_id(catid);
	            }
	            ps.setInt(9, category.getCat_id());
	            status = ps.executeUpdate();
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return status;
	}

	@Override
	public int update(Book book) {
		 int status=0;
         try {
             query="update book set title=?,author=?,description=?,isbn=?,price=?,publish_date=?,last_update_time=?,category_id=? where book_id=?";
             ps=this.con.prepareStatement(query);
             
             ps.setString(1, book.getB_title());
             ps.setString(2, book.getAuthor());
             ps.setString(3, book.getDesc());
             ps.setString(4, book.getIsbn());
             ps.setFloat(5, book.getPrice());
             ps.setObject(6, book.getPublishDate());
             ps.setObject(7, new Date());
             
             
             
             
             //fetch category name by categori id
             String query1="select * from category where category_name=?";
             PreparedStatement ps1=this.con.prepareStatement(query1);
             
             ps1.setString(1, book.getCategory().getName());
             ResultSet rs1=ps1.executeQuery();
             Category category=null;

             if(rs1.next()){
                 category=new Category();
                 int catid=rs1.getInt("category_id");
                 category.setCat_id(catid);
             }
             ps.setInt(8, category.getCat_id());
             ps.setInt(9, book.getB_id());
             status=ps.executeUpdate();
             
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         return status;
	}

	@Override
	public int delete(int id) {
		 int status=0;
         try {
             query="delete from book where book_id=?";
            ps=this.con.prepareStatement(query);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            
         } catch (Exception e) {
         }
         return  status;
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
	
	public Book findByTitle(String title) {
		Book book=null;
        try {
            query="select * from book where title=?";
            ps=this.con.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery();
            
             while(rs.next()){
                book=new Book();
                book.setB_id(rs.getInt("book_id"));
                book.setB_title(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setDesc(rs.getString("description"));
                book.setIsbn(rs.getString("isbn"));
                book.setPic(rs.getBytes("image"));
                book.setPublishDate(rs.getDate("publish_date"));
                
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  book;
	}
	
	public Book getBookById(int id){
        Book book=new Book();
        try {
            query="select * from book where book_id=?";
            ps=this.con.prepareStatement(query);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                book.setB_id(rs.getInt("book_id"));
                book.setB_title(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setDesc(rs.getString("description"));
                book.setIsbn(rs.getString("isbn"));
                book.setPic(rs.getBytes("image"));
                book.setPrice(rs.getFloat("price"));
                book.setPublishDate(rs.getDate("publish_date"));
                book.setLastUpdateTime(rs.getDate("last_update_time"));
                
                
                
                String query1="select * from category where category_id=?";
                PreparedStatement ps2=this.con.prepareStatement(query1);
                ps2.setInt(1, rs.getInt("category_id"));
                ResultSet rs2=ps2.executeQuery();
                Category category=null;
                if(rs2.next())
                {
                     category=new Category();
                     category.setCat_id(rs2.getInt("category_id"));
                     category.setName(rs2.getString("category_name"));
                }
                
                book.setCategory(category);
                
                
                
//                String query2="select * from Review where book_id=?";
//                PreparedStatement ps3=this.con.prepareStatement(query2);
//                ps3.setInt(1, rs.getInt("book_id"));
//                ResultSet rs3=ps3.executeQuery();
//                Review review=null;
//                Set<Review> setReviews1=null;
//                while(rs3.next())
//                {
//                	review=new Review();
//                	review.setHeadline(rs3.getString("headline"));
//                	review.setRating(rs3.getInt("rating"));
//                	 setReviews1=new HashSet<Review>();
//                	 setReviews1.add(review);
//                	 System.out.println(review);
//                	 System.out.println(setReviews1);
//                }
//               
//                
//                book.setReviews(setReviews1);
//                 
                return book;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
	
	  public List<Book> listBookByCategory(int categoryId){
          List<Book> booksList=new ArrayList<>();
         
        try {
            query="select * from category c right JOIN book b  ON b.category_id=c.category_id where c.category_id=?";
            ps=this.con.prepareStatement(query);
            ps.setInt(1,categoryId);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Book book=new Book();
                Category category=new Category();
                
                book.setB_id(rs.getInt("book_id"));
                book.setB_title(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setDesc(rs.getString("description"));
                book.setIsbn(rs.getString("isbn"));
                book.setPic(rs.getBytes("image"));
                book.setPrice(rs.getFloat("price"));
                book.setPublishDate(rs.getDate("publish_date"));
                book.setLastUpdateTime(rs.getDate("last_update_time"));
                
                category.setName(rs.getString("category_name"));
                category.setCat_id(rs.getInt("category_id"));
                
                booksList.add(book);
           }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
     }
	  
	  public List<Book> listNewBook(){
          List<Book> booksList=new ArrayList<>();
          Set<Review> reviews=new HashSet<Review>();
          Review review=null;
        try {
            query="select * from book order by publish_date desc";
            ps=this.con.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
            	review= new Review();
                Book book=new Book();
                Category category=new Category();
                
                book.setB_id(rs.getInt("book_id"));
                book.setB_title(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setDesc(rs.getString("description"));
                book.setIsbn(rs.getString("isbn"));
                book.setPic(rs.getBytes("image"));
                book.setPrice(rs.getFloat("price"));
                book.setPublishDate(rs.getDate("publish_date"));
                book.setLastUpdateTime(rs.getDate("last_update_time"));
                
                
                review.setBook(book);
                reviews.add(review);
                book.setReviews(reviews);
                
                booksList.add(book);
                
           }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
     }
	  
	  public ArrayList<Integer> listBestSellingBookIds(){
          ArrayList<Integer> al=new ArrayList<Integer>();
        try 
        {
            query="select book_id from order_detail group by book_id order by sum(quantity) desc";
            ps=this.con.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            { 
            	int bookId=rs.getInt("book_id");
           	
				al.add(bookId);
				 
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return al;
     }
	  
	  public List<Book> listBestSellingBook(List<Integer> ids){
          List<Book> booksList=new ArrayList<>();
         
        try {
        	for(int id:ids) {
	        	query="select * from book where book_id=?";
	        	ps=this.con.prepareStatement(query);
	            ps.setInt(1, id);
	            rs=ps.executeQuery();
	            while(rs.next())
	            {
	                Book book=new Book();
	                Category category=new Category();
	                
	                book.setB_id(rs.getInt("book_id"));
	                book.setB_title(rs.getString("title"));
	                book.setAuthor(rs.getString("author"));
	                book.setDesc(rs.getString("description"));
	                book.setIsbn(rs.getString("isbn"));
	                book.setPic(rs.getBytes("image"));
	                book.setPrice(rs.getFloat("price"));
	                book.setPublishDate(rs.getDate("publish_date"));
	                book.setLastUpdateTime(rs.getDate("last_update_time"));
	               
	                booksList.add(book);
	           }
	            
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
     }
	  
	  
	  public List<Book> searchBook(String str){
          List<Book> booksList=new ArrayList<>();
         
        try {
            query="select * from book where title like concat('%',?,'%') or author like concat('%',?,'%') or description like concat('%',?,'%')";
            ps=this.con.prepareStatement(query);
            ps.setString(1,str);
            ps.setString(2,str);
            ps.setString(3,str);
            
            rs=ps.executeQuery();
            while(rs.next())
            {
                Book book=new Book();
                Category category=new Category();
                
                book.setB_id(rs.getInt("book_id"));
                book.setB_title(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setDesc(rs.getString("description"));
                book.setIsbn(rs.getString("isbn"));
                book.setPic(rs.getBytes("image"));
                book.setPrice(rs.getFloat("price"));
                book.setPublishDate(rs.getDate("publish_date"));
                book.setLastUpdateTime(rs.getDate("last_update_time"));
               
                booksList.add(book);
           }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
     }
	  
	  public long countByCategory(int catId) throws SQLException {
		  query="select count(*) from book b join category c on b.category_id=c.category_id and c.category_id=?";
          ps=this.con.prepareStatement(query);
          ps.setInt(1,catId);
          int count=0;
          rs=ps.executeQuery();
          while(rs.next()) {
        	  count=rs.getInt(1);
          }
          return count;
	  }
}
