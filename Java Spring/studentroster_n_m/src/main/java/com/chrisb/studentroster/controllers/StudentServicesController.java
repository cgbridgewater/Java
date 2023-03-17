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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chrisb.studentroster.models.Classes;
import com.chrisb.studentroster.models.Dorm;
import com.chrisb.studentroster.models.Student;
import com.chrisb.studentroster.services.ClassesService;
import com.chrisb.studentroster.services.DormService;
import com.chrisb.studentroster.services.StudentService;

@Controller
public class StudentServicesController {

	
	@Autowired 
	DormService dormServ;
	@Autowired 
	StudentService studentServ;	
	@Autowired 
	ClassesService classServ;
	
	// Landing Page
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	
	
	// // SHOW ALLS  // //
	
	// Show All Dorms Display Page
	@GetMapping("/dorms")
	public String showDorms(Model model) {
		List<Dorm> allDorms = dormServ.getAll();
		model.addAttribute("allDorms",allDorms);		
		List<Student> allStudents = studentServ.getAll();
		model.addAttribute("allStudents",allStudents);
		return "dorms.jsp";
	}
	
	
	// Show All Classes Display Page
	@GetMapping("/classes")
	public String showClass(Model model) {
		List<Classes> allClasses = classServ.getAll();
		model.addAttribute("allClasses",allClasses);
			return "classes.jsp";
	}
	
	
	
	// Show All Students Display Page
	
	
	
	
	
	// // SHOW ONE PAGES // //
	
	
	// Show One Dorm and Associated Students
	@GetMapping("/dorms/{dorm_id}")
	public String showDorm(@ModelAttribute("newStudent") Student newStudent,@PathVariable("dorm_id")Long dorm_id, Model model) {
		Dorm oneDorm = dormServ.findById(dorm_id);
		model.addAttribute("oneDorm",oneDorm);
		List<Student> allStudents = studentServ.getAll();
		model.addAttribute("allStudents",allStudents);
			return "onedorm.jsp";
	}
	
	
	
	// Show One Class
	@GetMapping("/classes/{id}")
	public String oneClass(@PathVariable("id") Long id ,Model model) {
		Classes oneClass = classServ.findById(id);
		model.addAttribute("oneClass",oneClass);
			return "oneclass.jsp";
	}
	
	
	// Show One Student
	@GetMapping("/students/{student_id}")
	public String showStudent(@PathVariable("student_id")Long student_id , Model model) {
		Student oneStudent = studentServ.findById(student_id);
		model.addAttribute("oneStudent",oneStudent);
		List<Classes> allClasses = classServ.getAll();
		model.addAttribute("allClasses",allClasses);
			return "onestudent.jsp";
	}
	
	
	
	
	
	
	
	// // FORM PAGES //  //
	
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
	
	@GetMapping("/classes/new")
	public String addClass(@ModelAttribute("newClass") Classes newClass) {
		return "newclass.jsp";
	}
	
	
	
	
	// // POST ROUTES // //
	
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
	
	@PostMapping("/classes/new")
	public String newClass(@Valid @ModelAttribute("newClass") Classes newClass, BindingResult result) {
		if(result.hasErrors()) {
			return "newclass.jsp";
		} else {
			classServ.create(newClass);
			return "redirect:/classes";
		}
	}
	
	
	
	@PutMapping("/students/{student_id}/update")
	public String updateClasses(@PathVariable("student_id")Long student_id, @RequestParam(name="classId")Long classId, Model model) {
		if (classId == 0) {
			Student oneStudent = studentServ.findById(student_id);
			model.addAttribute("oneStudent",oneStudent);
			List<Classes> allClasses = classServ.getAll();
			model.addAttribute("allClasses",allClasses);
				return "onestudent.jsp";
			}	
		Classes classes = classServ.findById(classId);
		Student student = studentServ.findById(student_id);
		List<Classes> classesList = student.getClassesWithStudents();
		classesList.add(classes);
		student.setClassesWithStudents(classesList);
		studentServ.create(student);
			return "redirect:/students/" + student_id;
	}
	
	
	
	// // UPDATE ROUTES // //

	@PutMapping("/students/update/{dorm_id}")
	public String updateStudent(@PathVariable("dorm_id") Long dorm_id, @RequestParam(value="student") Long student_id) {
		Student student = studentServ.findById(student_id);
		Dorm dorm = dormServ.findById(dorm_id);
		student.setDorm(dorm);
		studentServ.update(student);
		return "redirect:/dorms/{dorm_id}";
	}
	
	
	
	
	// // "DELETE" ROUTES
	// ONE TO MANY
	// Remove Student from dorm                  // FIX THIS!!
	@GetMapping("/students/{id}/update")
	public String removeStudent(@PathVariable("id") Long id){
		Student oneStudent = studentServ.findById(id);
		studentServ.removeFromDorm(oneStudent);
		return "redirect:/dorms/";
	}

	

	
	// MANY TO MANY
	@PostMapping("/classes/{studentId}/update")
	public String removeClass(@PathVariable("studentId") Long studentId, @RequestParam(name="classId") Long classId) {
		Student oneStudent = studentServ.findById(studentId);
		Classes oneClass = classServ.findById(classId);
		List<Student> studentList = oneClass.getStudentsInClass();
		studentList.remove(oneStudent);
		oneClass.setStudentsInClass(studentList);
		classServ.create(oneClass);
		return "redirect:/students/" + studentId;
	}
	
	
	
	
	
	
	
	
	
}
