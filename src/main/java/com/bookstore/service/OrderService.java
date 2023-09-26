/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.DB_Connection;
import com.bookstore.dao.OrderDao;
import com.bookstore.dao.OrderDetailDao;
import com.bookstore.entities.Book;
import com.bookstore.entities.BookOrder;
import com.bookstore.entities.Customer;
import com.bookstore.entities.OrderDetail;
import com.bookstore.frontend.shoppingcart.ShoppingCart;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderService {

    private OrderDao orderDao;
    private OrderDetailDao orderDetailDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Set<OrderDetail> orderDetails=null;
    OrderDetail orderDetail=null;
    
    public OrderService(HttpServletRequest request,HttpServletResponse response) {
        this.request=request;
        this.response=response;
        orderDao=new OrderDao(DB_Connection.getConnection());
        orderDetailDao=new OrderDetailDao(DB_Connection.getConnection());
        
    }
    
    
    public void getAllOrders() throws IOException,ServletException{
    	getAllOrders(null);
    }
    
    public void getAllOrders(String message) throws IOException,ServletException{
        List<BookOrder> allOrders = orderDao.listAll();System.out.println(allOrders);
        request.setAttribute("allOrders", allOrders);
        
        if(message!=null)
        	request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("order_list.jsp");
        requestDispatcher.forward(request, response);

    }


	public void showCheckoutForm() throws IOException,ServletException{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("frontend/checkout.jsp");
        requestDispatcher.forward(request, response);
	}


	public void placeOrder() throws IOException,ServletException {
		
		String recipientName=request.getParameter("recipientname");
		String recipientPhone=request.getParameter("recipientphone");
		String address=request.getParameter("recipientaddress");
		String city=request.getParameter("city");
		String zipcode=request.getParameter("zipcode");
		String country=request.getParameter("country");
		String paymentMethod=request.getParameter("paymentmethod");
		String shippingAddress=address+","+city+"-"+zipcode+","+country;

		BookOrder order=new BookOrder();
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(shippingAddress);
		order.setPaymentMethod(paymentMethod);
		
//		int random = (int )(Math.random() * 10000 + 1);
		
//		order.setOrder_id(1);
	
		Customer customer= (Customer)request.getSession().getAttribute("loggedCustomer");
		order.setCustomer(customer);
		
		ShoppingCart shoppingCart=(ShoppingCart)request.getSession().getAttribute("cart");
		Map<Book, Integer> items = shoppingCart.getItems();
		
		order.setTotal(shoppingCart.getTotalAmount());
		order.setOrderDetails(orderDetails);
		
		orderDao.create(order);
		
		
		int lastRecord = orderDao.lastRecord();
		
		Iterator<Book> iterator=items.keySet().iterator();
		
//		orderDetails=new HashSet<OrderDetail>();
		Book book=null;
		while (iterator.hasNext()) {
			book = (Book) iterator.next();
			Integer quantity=items.get(book);
			float subtotal=quantity*book.getPrice();

			orderDetail=new OrderDetail();System.out.println("last "+lastRecord);
			orderDetail.setOrder_id(lastRecord);
			orderDetail.setBook(book);
			orderDetail.setBookOrder(order);
			orderDetail.setQuantity(quantity);
			orderDetail.setSubtotal(subtotal);
			
			
			orderDetailDao.create(orderDetail);
			
//			orderDetails.add(orderDetail);
			
		}
		shoppingCart.clear();
		
		
		
		
		String message="Your order is placed";
		request.setAttribute("message", message);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("frontend/message.jsp");
        requestDispatcher.forward(request, response);
	}


	public void viewOrderDetailForAdmin() throws IOException,ServletException{
		int orderId = Integer.parseInt(request.getParameter("id"));	
		
		BookOrder order = orderDao.getBookOrderById(orderId);
		request.setAttribute("order", order);
		
		List<OrderDetail> orderDetailById = orderDetailDao.getOrderDetailById(orderId);
		request.setAttribute("orderDetailById", orderDetailById);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("order_detail.jsp");
        requestDispatcher.forward(request, response);
	}


	public void listOrdersByCustomer() throws IOException,ServletException{
		Customer customer= (Customer)request.getSession().getAttribute("loggedCustomer");
		
		List<BookOrder> bookOrderByCustomerId = orderDao.getBookOrderByCustomerId(customer.getCust_id());
		request.setAttribute("listOrders", bookOrderByCustomerId);
//		request.setAttribute("customer", customer);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("frontend/order_list.jsp");
        requestDispatcher.forward(request, response);
	}


	public void showOrderDetailForCustomer() throws IOException,ServletException{		
		int orderId = Integer.parseInt(request.getParameter("id"));
		
		BookOrder bookOrderById = orderDao.getBookOrderById(orderId);
		request.setAttribute("order", bookOrderById);
		
		List<OrderDetail> orderDetailById = orderDetailDao.getOrderDetailById(orderId);
		request.setAttribute("orderDetailById", orderDetailById);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("frontend/order_detail.jsp");
        requestDispatcher.forward(request, response);
	}
    
//    public void createUser() throws ServletException,IOException{
//        int status=0;
//        User newUser=null;
//        
//        String name=request.getParameter("name");
//        String email=request.getParameter("email");
//        String password=request.getParameter("password");
//        
//        //fetch  the user with this email
//        User userByEmail = userDao.getByEmail(email);
//        
//        //check email is already exist or not
//        if(userByEmail!=null){
//            System.out.println("exist krti hai ye");
//            
//            String message="email already exist: "+email;
//            request.setAttribute("message", message);
//            
//            RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
//            rd.forward(request, response);
//        }
//        else{
//            //if email is not already exist, then insert the data
//            newUser=new User(name,email,password);
//            status = userDao.create(newUser);
//            getAllUsers("created user ho gaya");
//            
//        }
//         
//    }
//    
//    public void editUser() throws ServletException,IOException{
//        
//        int id = Integer.parseInt(request.getParameter("id"));
//        
//        User user = userDao.getById(id);
////        userDao.findUserByEmail(email)
//        
//        request.setAttribute("user", user);
//        
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user_form.jsp");
//        requestDispatcher.forward(request, response);
//            
//    }
//    
//    public void updateUser() throws ServletException,IOException{
//        
//        int id = Integer.parseInt(request.getParameter("id"));
//        
//        String name=request.getParameter("name");
//        String email=request.getParameter("email");
//        String password=request.getParameter("password");
//        
//        User userById = userDao.getById(id);
//        User userByEmail = userDao.getByEmail(email);
//         
//        if(userByEmail!=null && userByEmail.getId()!=userById.getId())
//        {
//            System.out.println("could not update");
//            String message="could not update "+email+" already exist";
//            request.setAttribute("message", message);
//            
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
//            requestDispatcher.forward(request, response);
//            
//        }
//        else{
//            User user=new User(id,name,email,password);
//            int updateUserDetails = userDao.update(user);
//
//            if(updateUserDetails!=0)
//            {
//                System.out.println("user updated");
//                String message="user updated successfully";
//                request.setAttribute("message", message);
//                getAllUsers();
//            }
//
//            else
//                System.out.println("error on update");
//            }
//        
//    }
//    
//    public void removeUser() throws IOException,ServletException{
//        int id = Integer.parseInt(request.getParameter("id"));
//        
//        int deleteUser = userDao.delete(id);
//        if(deleteUser!=0)
//        {
//            String message="user deleted successfully";
//            request.setAttribute("message", message);
//            
//            getAllUsers(message);
//            
//        }
//    }
//    
//    public void userLogin() throws IOException,ServletException{
//        String email = request.getParameter("email");
//        String pass = request.getParameter("password");
//        
//        boolean loginStatus = userDao.login(email,pass);
//        
//        if(loginStatus)
//        {
//            System.out.println("user login success");
//            request.getSession().setAttribute("userEmail", email);
//            
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
//            requestDispatcher.forward(request, response);
//            
//        }
//        else
//        {
//            System.out.println("not login");
//            String message="Login Failed, Please try again";
//            request.setAttribute("message", message);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
//            requestDispatcher.forward(request, response);
//        }
//            
//    }
    
    	

}
