package com.chrisb.authentication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty (message="User Name is required!")
	@Size(min=3,max=30, message="Min length 3 charactors")
	private String title;
	
	@NotEmpty (message="Description required!")
	@Size(min=3, max=500, message="Description must at least contain 3 charactors")
	private String description;
	
	
	@NotNull (message="Date required!")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@FutureOrPresent( message = "Date must be in future.")
	private Date date;
	
	private boolean Completed;
	
	// Table Joins		
	@OneToMany(mappedBy="project", fetch=FetchType.LAZY, cascade=CascadeType.ALL )
	private List<Task> tasks; 

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private User lead;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_projects", 
        joinColumns = @JoinColumn(name = "project_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;   //collect stuff from OTHER class
	
		
	public Project() {}
	

	public User getLead() {
		return lead;
	}


	public void setLead(User lead) {
		this.lead = lead;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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
	

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isCompleted() {
		return Completed;
	}

	public void setCompleted(boolean completed) {
		Completed = completed;
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
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
