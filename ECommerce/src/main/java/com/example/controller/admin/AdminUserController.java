package com.example.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.HelloWorldController;
import com.example.model.User;
import com.example.service.MailService;
import com.example.service.UserService;

@Controller
public class AdminUserController extends HelloWorldController {

	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value="/admin/users/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id)
	{
		User user = userService.getUser(id);
		userService.deleteUser(user);
		return "redirect:/admin/users/user";
		
	}
	
	@RequestMapping(value="admin/users/changeStatus/{id}",method = RequestMethod.GET)
	public String changestatus(@PathVariable int id)
	{
		User user = userService.getUser(id);
		if (user.isActive()){
			user.setActive(false);
		} else{
			user.setActive(true);
		}
		userService.updateUser(user);
		
		mailService.sendEmail(user);
		
		return "redirect:/admin/users/user";
	}
	
	@RequestMapping(value="/admin/users/user", method = RequestMethod.GET)
	public String viewUsers(ModelMap model)
	{
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("user", getPrincipal());
		return "admin/users/user";
		
	}
	
	
}
