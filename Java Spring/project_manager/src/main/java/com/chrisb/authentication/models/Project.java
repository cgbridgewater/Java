package com.chrisb.authentication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
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
	
	@NotNull 
	private Integer manager;
	
	@NotEmpty
	private String creator;
	

	@NotEmpty (message="Date required!")
	@DateTimeFormat(pattern="dd-MM-yyyy")
//	@FutureOrPresent( message = "creation date must be in future.")
	private String date;
	
	@OneToMany(mappedBy="project", fetch=FetchType.LAZY)
	private List<Task> tasks; 

	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "project_team", 
        joinColumns = @JoinColumn(name = "projects_id"),  //column from THIS class
        inverseJoinColumns = @JoinColumn(name = "users_id") // column from OTHER class
    )
    private List<User> userTeam;   //collect stuff from OTHER class
	
	

	public Project() {}
	
	
	
	public List<User> getUserTeam() {
		return userTeam;
	}

	public void setUserTeam(List<User> userTeam) {
		this.userTeam = userTeam;
	}

	public String getCreator() {
		return creator;
	}
	

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}


	public Integer getManager() {
		return manager;
	}
	
	public void setManager(Integer manager) {
		this.manager = manager;
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
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
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
