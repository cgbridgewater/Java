package com.chrisb.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")	// table name in MySQL
public class Book {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @NotEmpty
	    @Size(min = 3, max = 200)
	    private String title;
	    
	    @NotEmpty
	    @Size(min = 3, max = 200)
	    private String description;
	    
	    @NotEmpty
	    @Size(min = 3, max = 40)
	    private String language;
	    
	    @NotNull
	    @Min(10)
	    private Integer numberOfPages;
	    
	    @NotEmpty
	    @Size(min = 3, max = 200)
	    private String author;
	    
	    // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    public Book() {}    //Required to be a Java Bean
	    
	    
	    public Book(String title, String desc, String lang, int pages, String author) {
	        this.title = title;
	        this.description = desc;
	        this.language = lang;
	        this.numberOfPages = pages;
	        this.author = author;
	    }
	    
	    
	    
	    
	    
	    
	    
	    public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getLanguage() {
			return language;
		}


		public void setLanguage(String language) {
			this.language = language;
		}


		public Integer getNumberOfPages() {
			return numberOfPages;
		}


		public void setNumberOfPages(Integer numberOfPages) {
			this.numberOfPages = numberOfPages;
		}


		public String getAuthor() {
			return author;
		}


		public void setAuthor(String author) {
			this.author = author;
		}


		public Date getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


		public Date getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}


	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
}
