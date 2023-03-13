package com.chrisb.authentication.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.chrisb.authentication.models.Comment;
import com.chrisb.authentication.models.Post;
import com.chrisb.authentication.models.User;
import com.chrisb.authentication.services.CommentService;
import com.chrisb.authentication.services.PostService;
import com.chrisb.authentication.services.UserService;

@Controller
@RequestMapping("/post")
public class PostController {

		@Autowired
		private UserService userServ;
		@Autowired
		private PostService postServ;
		@Autowired
		private CommentService commentServ;
		
		
		@PostMapping("/new")
		public String createPost(@Valid @ModelAttribute("post") Post post, BindingResult result, Model model, HttpSession session) {
			Long userId = (Long) session.getAttribute("userId");
			User user = userServ.findById(userId);
			if (result.hasErrors()) {
				model.addAttribute("user", user);
					return "dashbaord.jsp";
			}
			post.setCreatedBy(user);
			postServ.create(post);
				return "redirect:/dashboard";
		}
		
		
		@GetMapping("/{id}/like")
		public String likePost(HttpSession session, @PathVariable("id") Long id) {
			Long userId = (Long) session.getAttribute("userId");
			User loggedUser = userServ.findById(userId);
			Post likedPost = postServ.getOneById(id);
//			List<User>users= likedPost.getLikedBy();
//			users.add(loggedUser);
//			likedPost.setLikedBy(users);
			postServ.like(loggedUser, likedPost);
				return "redirect:/dashboard";
		}
		
		
		@GetMapping("/{id}")
		public String showPost(HttpSession session, @PathVariable("id") Long id, Model model) {
			Long userId = (Long) session.getAttribute("userId");
			Post post = postServ.getOneById(id);
			model.addAttribute("comment", new Comment());
			model.addAttribute("post",post);
			model.addAttribute("idInSession",userId);
				return "viewpost.jsp";
		}
	
		
		@PostMapping("/{postId}/addcomment")
		public String addComment(@ModelAttribute("comment") Comment comment, HttpSession session, @PathVariable("postId") Long postId) {
			Long userId = (Long) session.getAttribute("userId");
			comment.setUser(userServ.findById(userId));
			Post post = postServ.getOneById(postId);
			comment.setPost(post);
	//		commentServ.create(comment);
			post.getComments().add(comment);
			postServ.update(post);
				return "redirect:/post/" + postId;	
		}
		
	
}
