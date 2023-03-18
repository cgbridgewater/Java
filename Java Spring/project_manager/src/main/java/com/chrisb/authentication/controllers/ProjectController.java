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
import org.springframework.web.bind.annotation.RequestParam;

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
		User user = userServ.findById(id);
		model.addAttribute("user",user);
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
		
		
		
		
	// POST ROUTES //
	
	@PostMapping("/projects/new")
	public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result) {
		if (result.hasErrors()) {
			return "newprojects.jsp";
	
		}
		projServ.create(project);
		return "redirect:/dashboard";
	}
	
	
	
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
	@PutMapping("/projects/edit/{id}")
	public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult result,@PathVariable("id")Long id, Model model, HttpSession session) {
		if (result.hasErrors()) {
			Long loggedid = (Long) session.getAttribute("userId");
			model.addAttribute(loggedid);
			Project oneProject = projServ.findById(id);
			model.addAttribute(oneProject);	
				return "editprojects.jsp";
	
		}
		projServ.update(project);
		return "redirect:/dashboard";
	}
	
	
	
	// JOIN ROUTE
	@PutMapping("/projects/{projid}/join")
	public String joinProject(@PathVariable("projid")Long projid, @RequestParam(value="users_id")Long users_id) {
		Project project = projServ.findById(projid);
		User user = userServ.findById(users_id);
		List<Project> projList = user.getTeamProjects();
		projList.add(project);
		user.setTeamProjects(projList);
		userServ.update(user);
			return "redirect:/dashboard";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Delete Route
	// DELETE
    @GetMapping("/projects/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
       	projServ.delete(id);
        return "redirect:/dashboard";
    }
	
	
	
	
	
	
	
	
	
	
	
}
