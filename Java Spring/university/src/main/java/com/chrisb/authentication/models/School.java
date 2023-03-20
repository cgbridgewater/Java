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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "schools")
public class School {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty (message="Min length 3 charactors")
	@Size(min=3, max=50, message="Min length 3 charactors")
	private String name;
	
	@NotEmpty (message="Min length 3 charactors")
	@Size(min=2, max=255, message="Min length 3 charactors")
	private String city;
	
	@NotNull (message="Selection Required")
	private String online;

	@NotNull (message="Selection Required")
	private String inperson;
	
	@NotNull (message="A year is required!")
	@Min(value=1, message="Must Include a year")
	private Integer founded;

	@NotNull (message="A enrollment is required!")
	@Min(value=1, message="Must have at least 1 student enrolled")
	private Integer enrolled;
	
	@OneToMany(mappedBy="school", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Hall> schoolHalls;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "schools_id")
	private User userSchool;
	
	
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
	
	public School () {}

	
	
	public Integer getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(Integer enrolled) {
		this.enrolled = enrolled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public String getInperson() {
		return inperson;
	}

	public void setInperson(String inperson) {
		this.inperson = inperson;
	}

	public Integer getFounded() {
		return founded;
	}

	public void setFounded(Integer founded) {
		this.founded = founded;
	}

	public List<Hall> getSchoolHalls() {
		return schoolHalls;
	}

	public void setSchoolHalls(List<Hall> schoolHalls) {
		this.schoolHalls = schoolHalls;
	}



	public User getUserSchool() {
		return userSchool;
	}

	public void setUserSchool(User userSchool) {
		this.userSchool = userSchool;
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
	
	
}
