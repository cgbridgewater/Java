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
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY) //mapped MUST match 
	private List<Song> songs;
	
	@OneToMany(mappedBy="users", fetch=FetchType.LAZY) //mapped MUST match 
	private List<Lyric> addedlyrics;
	
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "contributions", //Table Name
        joinColumns = @JoinColumn(name = "user_id"),  //column from THIS class
        inverseJoinColumns = @JoinColumn(name = "song_id") // column from OTHER class
    )
    private List<Song> songlist;
	
	
    public User() {}
	
	public List<Song> getSonglist() {
		return songlist;
	}

	public void setSonglist(List<Song> songlist) {
		this.songlist = songlist;
	}

	public List<Lyric> getAddedlyrics() {
		return addedlyrics;
	}

	public void setAddedlyrics(List<Lyric> addedlyrics) {
		this.addedlyrics = addedlyrics;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
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
