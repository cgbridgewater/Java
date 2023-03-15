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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "questions")
public class Question {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Size(min=3, max=500, message="Min length 3 charactors")
	private String text;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//One to Many with Answer
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<Answer> answers;
	
	
	//Many to Many to Tag
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "question_tags", 
            joinColumns = @JoinColumn(name = "questions_id"), 
            inverseJoinColumns = @JoinColumn(name = "tags_id")
        )
        private List<Tag> tags;
        
	
	public List<Answer> getAnswers() {
	return answers;
}


public void setAnswers(List<Answer> answers) {
	this.answers = answers;
}


public List<Tag> getTags() {
	return tags;
}


public void setTags(List<Tag> tags) {
	this.tags = tags;
}


	public Question() {}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
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
