package com.chrisb.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chrisb.studentroster.models.Dorm;
import com.chrisb.studentroster.models.Student;
import com.chrisb.studentroster.services.DormService;
import com.chrisb.studentroster.services.StudentService;

@Controller
public class StudentServicesController {

	
	@Autowired 
	DormService dormServ;
	@Autowired 
	StudentService studentServ;
	
	// Landing Page
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// Main Dorm Display Page
	@GetMapping("/dorms")
	public String showDorms(Model model) {
		List<Dorm> allDorms = dormServ.getAll();
		model.addAttribute("allDorms",allDorms);
		return "dorms.jsp";
	}
	
	// Add Dorm Page
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("newDorm") Dorm newDorm) {
		return "newdorm.jsp";
	}
	
	// Add Student Page
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("newStudent") Student newStudent, Model model) {
		List<Dorm> allDorms = dormServ.getAll();
		model.addAttribute("allDorms",allDorms);
		return "newstudent.jsp";
	}
	
	
	// Show One Dorm and Associated Students
	@GetMapping("/dorms/{dorm_id}")
	public String showDorm(@ModelAttribute("newStudent") Student newStudent,@PathVariable("dorm_id")Long dorm_id, Model model) {
		Dorm oneDorm = dormServ.findById(dorm_id);
		model.addAttribute("oneDorm",oneDorm);
		List<Student> allStudents = studentServ.getAll();
		model.addAttribute("allStudents",allStudents);
			return "onedorm.jsp";
	}
	
	
	
	// Create Dorm Action Route
	@PostMapping("/dorms/create")
	public String createDorm(@Valid @ModelAttribute("newDorm") Dorm newDorm, BindingResult result) {
		if(result.hasErrors()) {
			return "newdorm.jsp";
		} else {
			dormServ.create(newDorm);
			return "redirect:/dorms";
		}
	}
	
	
	// Create Student Action Route
	@PostMapping("/students/create")
	public String newStudent(@Valid @ModelAttribute("newStudent")Student newStudent, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dorm> allDorms = dormServ.getAll();
			model.addAttribute("allDorms",allDorms);
			return "newstudent.jsp";
		}else {
			studentServ.create(newStudent);
				return "redirect:/dorms";
		}
	}
	
	
//	// Update Student Action Route
//	@PutMapping("/students/update/{dorm_id}")
//	public String updateStudent(@Valid @ModelAttribute("newStudent") Student newStudent, BindingResult result, @PathVariable("dorm_id")Long dorm_id, Model model) {
//		if(result.hasErrors()) {
//			Dorm oneDorm = dormServ.findById(dorm_id);
//			model.addAttribute("oneDorm",oneDorm);
//			List<Student> allStudents = studentServ.getAll();
//			model.addAttribute("allStudents",allStudents);
//			return "onedorm.jsp";
//		} else {
//			studentServ.update(newStudent);
//			return "redirect:/dorms/{dorm_id}";
//		}
//	}

	@PutMapping("/students/update/{dorm_id}")
	public String updateStudent(@PathVariable("dorm_id") Long dorm_id, @RequestParam(value="student") Long student_id) {
		Student student = studentServ.findById(student_id);
		Dorm dorm = dormServ.findById(dorm_id);
		student.setDorm(dorm);
		studentServ.update(student);
		return "redirect:/dorms/{dorm_id}";
	}
	
	// Remove Student from dorm
	@GetMapping("/students/{student_id}/update")
	public String removeStudent(@PathVariable("student_id") Long student_id){
		studentServ.delete(student_id);
		return "redirect:/dorms";
	}
	
	
	
	
	
}
