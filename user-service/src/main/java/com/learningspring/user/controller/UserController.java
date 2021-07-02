package com.learningspring.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learningspring.user.entity.ReponseTemplateVO;
import com.learningspring.user.entity.User;
import com.learningspring.user.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user)
	{
		log.info("Start:inside UserController ->saveUser");
		return userService.saveUser(user);
		
	}
	
//	@GetMapping("/{userId}")
//	public User findUserById(@PathVariable("userId") Long userId)
//	{
//		log.info("Start:inside UserController ->findUserById");
//		return userService.findUserById(userId);
//		
//	}
	
	@GetMapping("/{id}")
	public ReponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId)
	{
		log.info("Start:inside UserController ->getUserWithDepartment");
		return userService.getUserWithDepartment(userId);
		
	}
//	@GetMapping("/hello-world")
//	public ReponseTemplateVO sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
//		return null;
//  }
	
}
