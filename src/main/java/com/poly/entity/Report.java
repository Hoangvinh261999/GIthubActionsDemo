package com.poly.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "Report.favoriteByYear",
procedureName = "spFavoriteByYear",
parameters = {
@StoredProcedureParameter(name="Year", type = Integer.class)},
resultClasses = {Report.class})
})
public class Report {
	@Id
	String title;
	Long likes;
	Date newest;
	Date oldest;
	
	
	public Report() {
	
	}

	

	public Report(String title, Long likes, Date newest, Date oldest) {
		super();
		this.title = title;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}



	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Long getLikes() {
		return likes;
	}


	public void setLikes(Long likes) {
		this.likes = likes;
	}


	public Date getNewest() {
		return newest;
	}


	public void setNewest(Date newest) {
		this.newest = newest;
	}


	public Date getOldest() {
		return oldest;
	}


	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}


//	public Report(Serializable title, Long likes, Date newest, Date oldest) {
//		
//		this.title = title;
//		this.likes = likes;
//		this.newest = newest;
//		this.oldest = oldest;
//	}
//
//
//	public Serializable getTitle() {
//		return title;
//	}
//
//
//	public void setTitle(Serializable title) {
//		this.title = title;
//	}
//
//
//	public Long getLikes() {
//		return likes;
//	}
//
//
//	public void setLikes(Long likes) {
//		this.likes = likes;
//	}
//
//
//	public Date getNewest() {
//		return newest;
//	}
//
//
//	public void setNewest(Date newest) {
//		this.newest = newest;
//	}
//
//
//	public Date getOldest() {
//		return oldest;
//	}
//
//
//	public void setOldest(Date oldest) {
//		this.oldest = oldest;
//	}
//	
	
	
	
//	public Report() {
//		
//	}
//	public Report(String title, Long likes, Date newest, Date oldest) {
//	
//		this.title = title;
//		this.likes = likes;
//		this.newest = newest;
//		this.oldest = oldest;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public Long getLikes() {
//		return likes;
//	}
//	public void setLikes(Long likes) {
//		this.likes = likes;
//	}
//	public Date getNewest() {
//		return newest;
//	}
//	public void setNewest(Date newest) {
//		this.newest = newest;
//	}
//	public Date getOldest() {
//		return oldest;
//	}
//	public void setOldest(Date oldest) {
//		this.oldest = oldest;
//	}
//	
//	
}
