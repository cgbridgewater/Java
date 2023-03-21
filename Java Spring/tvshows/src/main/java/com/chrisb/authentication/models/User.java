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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty 
	@Size(min=3,max=30, message="Min length 3 charactors")
	private String userName;
	
	@NotEmpty (message="Email Required")
	@Email (message="Must be in valid email format")
	private String email;
	
	@NotEmpty
	@Size(min=8, message="Min length 8 charactors")
	private String password;
	
	@Transient
	private String confirmPass;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//JOINS
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "liked_shows", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "show_id")
        )
    	private List<Show> showLiked;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tv_programs", 
        joinColumns = @JoinColumn(name = "show_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
        )
    	private List<Show> programs;
    
    @OneToMany(mappedBy="showCreator", fetch=FetchType.LAZY) //mapped MUST match 
    private List<Show> showscreated;
    
	public User() {}
	
	public List<Show> getShowLiked() {
		return showLiked;
	}

	public void setShowLiked(List<Show> showLiked) {
		this.showLiked = showLiked;
	}

	public List<Show> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Show> programs) {
		this.programs = programs;
	}

	public List<Show> getShowscreated() {
		return showscreated;
	}

	public void setShowscreated(List<Show> showscreated) {
		this.showscreated = showscreated;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
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
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
