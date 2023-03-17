package com.chrisb.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.studentroster.models.Student;
import com.chrisb.studentroster.repositories.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studentRepo;
	
		//GETALL 
	public List<Student> getAll(){
		return studentRepo.findAll();
	}
	
	//Create
	public Student create(Student b) {
		return studentRepo.save(b);
	}

	//UPDATE
	public Student update(Student b) {
		return studentRepo.save(b);
	}
			
	//GET ONE 
	public Student findById(Long id) {
		Optional<Student> optStudent = studentRepo.findById(id);
		if(optStudent.isPresent()) {
			return optStudent.get();
		}else {
			return null;
		}
	}
	
    // DELETE 
    public void delete(Long id) {
    	studentRepo.deleteById(id);
    }

	
	public void removeFromDorm(Student s) {
		s.setDorm(null);
		studentRepo.save(s);
	}
	
}
