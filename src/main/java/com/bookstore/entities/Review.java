/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entities;

import java.beans.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Review {
	private int review_id;
	private int rating;
	private String headline;
	private String comment;
	private Date reviewDate;	
	 private Book book;
	 private Customer customer;
	    
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Transient
    public String getStars() {
    	String result="";
    	
    	int numberOfStarsOn=(int)rating;
    	
    	for (int i = 1; i <= numberOfStarsOn; i++) {
			result+="on,";
		}
    	
    	for (int i = numberOfStarsOn+1; i <= 5; i++) {
			result+="off,";
		}
    	
    	return result.substring(0, result.length()-1);
    }	
	
	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", rating=" + rating + ", headline=" + headline + ", comment="
				+ comment + ", reviewDate=" + reviewDate + ", book=" + book + ", customer=" + customer + "]";
	}
	
	
}
