package com.chrisb.authentication.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.chrisb.authentication.models.Project;
import com.chrisb.authentication.models.Task;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.ProjectService;
import com.chrisb.authentication.services.TaskService;
import com.chrisb.authentication.services.UserService;

@Controller
public class ProjectController {

	
	@Autowired
	UserService userServ;
	@Autowired
	ProjectService projServ;	
	@Autowired
	TaskService taskServ;	
	
	
	//  Get Routes   //
	
	
	// New Project Form
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project")Project project, HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) { //if none in session gtfo!
			return "redirect:/";
		}
		
		model.addAttribute("user",id);
		return "newprojects.jsp";
	}
	
	
	// Update Project Form
	@GetMapping("/projects/edit/{projid}")
	public String editProject(@ModelAttribute("project")Project project,@PathVariable("projid") Long projid, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		model.addAttribute("user",user);
		Project oneProject = projServ.findById(projid);
		model.addAttribute("project", oneProject);
		return "editprojects.jsp";
	}
	
	
	
	@GetMapping("/projects/{id}")
	public String oneProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		model.addAttribute(user);
		Project oneProject = projServ.findById(id);
		model.addAttribute("project", oneProject);
		return "oneproject.jsp";
	}
	
	
	
	@GetMapping("/projects/{projid}/tasks")
	public String projectTasks(@ModelAttribute("task") Task task,@PathVariable("projid") Long projid, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		model.addAttribute("user",user);
		Project oneProject = projServ.findById(projid);
		model.addAttribute("project", oneProject);
		return "projecttasks.jsp";
	}
		
	
	
	// JOIN Proj 
	@GetMapping("/projects/{projid}/join")
	public String joinProject(@PathVariable("projid")Long projid, HttpSession session, Model model) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		Project project = projServ.findById(projid);
		User user = userServ.findById(loggedid);
		user.getProjects().add(project);
		userServ.update(user);
		List<Project> assignedProj = projServ.getAssignedProjects(user);
		List<Project> unassignedProj = projServ.getUnassignedProjects(user);
		model.addAttribute("user", user);
		model.addAttribute("unassignedProj",unassignedProj);
		model.addAttribute("assignedProj",assignedProj);
			return "redirect:/dashboard";
		
		
	}
	
	
	// Leave Proj
    @GetMapping("/projects/{projid}/leave")
    public String delete(@PathVariable("projid")Long projid, HttpSession session, Model model) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		Project project = projServ.findById(projid);
		User user = userServ.findById(loggedid);
    	user.getProjects().remove(project);
    	userServ.update(user);
    	List<Project> assignedProj = projServ.getAssignedProjects(user);
		List<Project> unassignedProj = projServ.getUnassignedProjects(user);
		model.addAttribute("user", user);
		model.addAttribute("unassignedProj",unassignedProj);
		model.addAttribute("assignedProj",assignedProj);
    
        return "redirect:/dashboard";
    }
	
	
    
    @GetMapping("/projects/{id}/delete")
    public String deleteProj(@PathVariable("id")Long id, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		Project project = projServ.findById(id);
				projServ.deleteProject(project);
		return "redirect:/dashboard";
    }
		
	
	
		
		
	// POST ROUTES //
	// Create new project action
	@PostMapping("/projects/new")
	public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) { //if none in session gtfo!
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			return "newprojects.jsp";
	
		}
		
		projServ.create(project);
		User user = userServ.findById(loggedid);
		user.getProjects().add(project);
		userServ.update(user);
		return "redirect:/dashboard";
	}
	
	
	//	create new task route
	@PostMapping("/projects/{projid}/tasks")
	public String newTask(@Valid @ModelAttribute("task")Task task, BindingResult result, @PathVariable("projid")Long projid, Model model, HttpSession session) {
		if (result.hasErrors()) {
			return "newprojects.jsp";
	
		}
		Long loggedid = (Long) session.getAttribute("userId");
		User user = userServ.findById(loggedid);
		model.addAttribute(user);
		Project oneProject = projServ.findById(projid);
		model.addAttribute("project", oneProject);
		taskServ.create(task);
		task.setProject(oneProject);
		projServ.update(oneProject);
		return "redirect:/projects/" + projid + "/tasks";
		
	}
	
	
	
	
	// UPDATE ROUTES  //
	//  Update project
	@PutMapping("/projects/edit/{projid}")
	public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult result,@PathVariable("projid")Long projid, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if (result.hasErrors()) {
			model.addAttribute(loggedid);
			Project oneProject = projServ.findById(projid);
			model.addAttribute(oneProject);	
				return "editprojects.jsp";
	
		}
		User user = userServ.findById(loggedid);
		Project projectupdate = projServ.findById(projid);
		project.setUsers(projectupdate.getUsers());
		project.setLead(user);
		projServ.update(project);
		

		return "redirect:/dashboard";
	}
	
	
}
