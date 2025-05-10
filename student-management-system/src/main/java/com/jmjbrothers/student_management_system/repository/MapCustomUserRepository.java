package com.jmjbrothers.student_management_system.repository;

import java.util.Map;

import com.jmjbrothers.student_management_system.model.CustomUser;

public class MapCustomUserRepository implements CustomUserRepository {

	private final Map<String, CustomUser> emailToCustomUser;

	public MapCustomUserRepository(Map<String, CustomUser> emailToCustomUser) {
		this.emailToCustomUser = emailToCustomUser;
	}

	@Override
	public CustomUser findCustomUserByEmail(String email) {
		return this.emailToCustomUser.get(email);
	}
}