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
	
	
	// Get Routes / VIEWS //
	//	                  //
	// PROJECTS DASHBOARD - ALL INCOMPETE PROJECTS
	@GetMapping("/projects/dashboard")
	public String dashboard(Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
			if(id == null) {
				return "redirect:/";
			}
			else {	
		User user = userServ.findById(id);
		List<Project> allProj = projServ.getIncompleteProjectsOrderedByDate();
		model.addAttribute("user", user);
		model.addAttribute("allProj", allProj);
		return "dashboard.jsp";
			}
	}
	
	
	// LOGGED USERS PROJECTS 
	@GetMapping("/projects/myprojects")
	public String myprojects(Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
			if(id == null) {
				return "redirect:/";
			}
			else {	
		User user = userServ.findById(id);
		List<Project> assignedProj = projServ.getAssignedProjects(user);
		model.addAttribute("user", user);
		model.addAttribute("assignedProj",assignedProj);
		return "myprojects.jsp";
			}
	}
	
	
	// COMPLETED PROJECTS 
	@GetMapping("/projects/completed")
	public String completed(Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
			if(id == null) {
				return "redirect:/";
			}
			else {	
		User user = userServ.findById(id);
		model.addAttribute("user", user);
		List<Project> allProj = projServ.getCompletedProjectsOrderedByDate();
		model.addAttribute("allProj", allProj);
		return "completedprojects.jsp";
			}
	}
	
	
	// CREATE PROJECT FORM
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project")Project project, HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("userId");
		if(id == null) {
			return "redirect:/";
		}
		User user = userServ.findById(id);
		model.addAttribute("user",user);
		model.addAttribute("loggedId",id);
			return "newprojects.jsp";
	}
	
	
	// UPDATE PROJECT FORM
	@GetMapping("/projects/edit/{projid}")
	public String editProject(@ModelAttribute("project")Project project,@PathVariable("projid") Long projid, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		model.addAttribute("user",user);
		Project oneProject = projServ.findById(projid);
		model.addAttribute("project", oneProject);
			return "editprojects.jsp";
	}
	
	
	// VIEW ONE PROJECT 
	@GetMapping("/projects/{id}")
	public String oneProject(@PathVariable("id") Long id, Model model,@ModelAttribute("task") Task task, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		model.addAttribute(user);
		Project oneProject = projServ.findById(id);
		model.addAttribute("project", oneProject);
			return "oneproject.jsp";
	}
	
	
	// ADD USER TO PROJECT RETURN TO MY PROJECTS
	@GetMapping("/projects/{projid}/join")
	public String joinProject(@PathVariable("projid")Long projid, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		Project project = projServ.findById(projid);
		User user = userServ.findById(loggedid);
		user.getProjects().add(project);
		userServ.update(user);
			return "redirect:/projects/myprojects";
	}
	
	
	// REMOVE USER FROM PROJECT RETURNT TO MY PROJECTS
    @GetMapping("/projects/{projid}/leave")
    public String leaveProject(@PathVariable("projid")Long projid, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		Project project = projServ.findById(projid);
		User user = userServ.findById(loggedid);
    	user.getProjects().remove(project);
    	userServ.update(user);
			return "redirect:/projects/myprojects";
    }
	
	// ADD USER TO PROJECT RETURN TO DASH
	@GetMapping("/projects/{projid}/joindash")
	public String joinProjectToDash(@PathVariable("projid")Long projid, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		Project project = projServ.findById(projid);
		User user = userServ.findById(loggedid);
		user.getProjects().add(project);
		userServ.update(user);
			return "redirect:/projects/dashboard";
	}
	
	
	// REMOVE USER FROM PROJECT RETURN TO DASH
    @GetMapping("/projects/{projid}/leavedash")
    public String leaveProjectToDash(@PathVariable("projid")Long projid, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		Project project = projServ.findById(projid);
		User user = userServ.findById(loggedid);
    	user.getProjects().remove(project);
    	userServ.update(user);
			return "redirect:/projects/dashboard";
    }
	

	// ADD USER TO PROJECT RETURN TO MY PROJECTS
	@GetMapping("/projects/{projid}/joinone")
	public String joinProjectToOneProject(@PathVariable("projid")Long projid, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		Project project = projServ.findById(projid);
		User user = userServ.findById(loggedid);
		user.getProjects().add(project);
		userServ.update(user);
		return "redirect:/projects/" + projid;
	}
	
	
	// REMOVE USER FROM PROJECT RETURNT TO MY PROJECTS
    @GetMapping("/projects/{projid}/leaveone")
    public String leaveProjectToOneProject(@PathVariable("projid")Long projid, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		Project project = projServ.findById(projid);
		User user = userServ.findById(loggedid);
    	user.getProjects().remove(project);
    	userServ.update(user);
			return "redirect:/projects/" + projid;
    }
	
    
    // MARK PROJECT COMPLETED //
	@GetMapping("/projects/completed/{projid}")
	public String completedProject(@PathVariable("projid")Long projid, HttpSession session) {

		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		Project projectupdate = projServ.findById(projid);
		projectupdate.setUsers(projectupdate.getUsers());
		projectupdate.setCompleted(true);
		projectupdate.setLead(user);
		projServ.update(projectupdate);
			return "redirect:/projects/" + projid;
	}
    
	
    // MARK PROJECT COMPLETED //
	@GetMapping("/projects/incomplete/{projid}")
	public String incompleteProject(@PathVariable("projid")Long projid, HttpSession session) {

		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		User user = userServ.findById(loggedid);
		Project projectupdate = projServ.findById(projid);
		projectupdate.setUsers(projectupdate.getUsers());
		projectupdate.setCompleted(false);
		projectupdate.setLead(user);
		projServ.update(projectupdate);
			return "redirect:/projects/" + projid;
	}
    
	
    // DELETE ROUTES //
	//               //
    // DELETE PROJECT    
    @GetMapping("/projects/{id}/delete")
    public String deleteProj(@PathVariable("id")Long id, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		Project project = projServ.findById(id);
		projServ.deleteProject(project);
			return "redirect:/projects/dashboard";
    }
    
    
    // DELETE TASK ROUTE    
    @GetMapping("/projects/{projid}/tasks/{id}/delete")
	public String deleteTask(@PathVariable("projid")Long projid, @PathVariable("id")Long id, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		Task task = taskServ.findById(id);
		taskServ.deleteTask(task);
			return "redirect:/projects/" + projid;
    }
	
		
	// CREATE ROUTES //
	//             //
	// CREATE NEW PROJECT ACTION
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
			return "redirect:/projects/dashboard";
	}
	
	
	//	CREATE NEW TASK ACTION
	@PostMapping("/projects/{projid}/tasks")
	public String newTask(@Valid @ModelAttribute("task")Task task, BindingResult result, @PathVariable("projid")Long projid, Model model, HttpSession session) {
		if (result.hasErrors()) {
			Long loggedid = (Long) session.getAttribute("userId");
			User user = userServ.findById(loggedid);
			model.addAttribute("user",user);
			Project oneProject = projServ.findById(projid);
			model.addAttribute("project", oneProject);
				return "oneproject.jsp";
		}
		Long loggedid = (Long) session.getAttribute("userId");
		User user = userServ.findById(loggedid);
		model.addAttribute(user);
		Project oneProject = projServ.findById(projid);
		model.addAttribute("project", oneProject);
		taskServ.create(task);
		task.setProject(oneProject);
		projServ.update(oneProject);
			return "redirect:/projects/" + projid;
	}
	
	
	// UPDATE ROUTES  //
	//                //
	//  Update project
	@PutMapping("/projects/edit/{projid}")
	public String updateProject(@Valid @ModelAttribute("project") Project project,  BindingResult result,  @PathVariable("projid")Long projid, Model model, HttpSession session) {
		Long loggedid = (Long) session.getAttribute("userId");
		if(loggedid == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			model.addAttribute(loggedid);
			Project oneProject = projServ.findById(projid);
			model.addAttribute("oneProject", oneProject);	
				return "editprojects.jsp";
		}
		User user = userServ.findById(loggedid);
		Project projectupdate = projServ.findById(projid);
		project.setUsers(projectupdate.getUsers());
		project.setLead(user);
		projServ.update(project);
			return "redirect:/projects/" + projid;
	}
}