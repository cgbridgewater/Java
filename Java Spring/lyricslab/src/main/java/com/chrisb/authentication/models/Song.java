package com.chrisb.authentication.models;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "songs")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty (message="Title Must Be Provided!!")
	@Size(min=3, max=50, message="Min length 3 charactors")
	private String title;
	
	@NotEmpty (message="Genre Must Be Provided!!")
	@Size(min=3, max=50,message="Genre min length 5 charactors")
	private String genre;
	
	@NotEmpty (message="Lyrics Must Be Provided!!")
	@Size(min=3, max=500,message="Lyrics min length 5 charactors")
	private String lyric;
	
	
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
	
	@OneToMany(mappedBy="song", fetch=FetchType.LAZY) //mapped MUST match 
	private List<Lyric> lyrics; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="songs_id") // THIS TABLE id
	private User user;  

	
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "contributions", //Table Name
        joinColumns = @JoinColumn(name = "song_id"),  //column from THIS class
        inverseJoinColumns = @JoinColumn(name = "user_id") // column from OTHER class
    )
    private List<User> contributors= new ArrayList<User>();
		
    
    
    public Song() {}


	public List<User> getContributors() {
		return contributors;
	}

	public void setContributors(List<User> contributors) {
		this.contributors = contributors;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public List<Lyric> getLyrics() {
		return lyrics;
	}

	public void setLyrics(List<Lyric> lyrics) {
		this.lyrics = lyrics;
	}


	
}
