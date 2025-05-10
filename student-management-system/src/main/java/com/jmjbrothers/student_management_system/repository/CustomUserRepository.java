package com.jmjbrothers.student_management_system.repository;

import com.jmjbrothers.student_management_system.model.CustomUser;

public interface CustomUserRepository {
	CustomUser findCustomUserByEmail(String email);
}
