package com.jmjbrothers.student_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmjbrothers.student_management_system.annotation.CurrentUser;
import com.jmjbrothers.student_management_system.model.CustomUser;

@RestController
public class UserController {

	@GetMapping("/user")
	public CustomUser user(@CurrentUser CustomUser currentUser) {
		return currentUser;
	}
}
