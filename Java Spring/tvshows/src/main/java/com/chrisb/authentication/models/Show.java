package com.chrisb.authentication.models;

import java.util.ArrayList;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "shows")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty (message="Title required!")
	@Size(min=3, message="Title must at least contain 3 charactors")
	private String title;
	
	@NotEmpty (message="Description required!")
	@Size(min=3, message="Description must at least contain 3 charactors")
	private String description;
	
	@NotNull (message="Rating required!")
	@Min(value=1,message="Rating must be between 1 and 5")
	@Max(value=5, message="Rating must be between 1 and 5")
	private Integer rating;
		
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
	
// Joins
	
	@OneToMany(mappedBy="showcomment", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Comment> comment; 

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "liked_shows", 
        joinColumns = @JoinColumn(name = "show_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
        )
    	private List<User> likedBy = new ArrayList<User>();
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tv_programs", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "show_id")
        )
    	private List<User> shows;
 
    @NotNull (message= "Select or Create a network!")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="networkshow_id") // THIS TABLE id
		private Network network; 
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="showcreator_id") // THIS TABLE id
		private User showCreator; 
		
	public Show() {}

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

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<User> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(List<User> likedBy) {
		this.likedBy = likedBy;
	}

	public List<User> getShows() {
		return shows;
	}

	public void setShows(List<User> shows) {
		this.shows = shows;
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public User getShowCreator() {
		return showCreator;
	}

	public void setShowCreator(User showCreator) {
		this.showCreator = showCreator;
	}


}
