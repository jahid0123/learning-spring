package com.jmjbrothers.student_management_system.dto;

import com.jmjbrothers.student_management_system.constants.Role;

import jakarta.validation.constraints.Email;

public record UserUpdateRequest(@Email(message = "Email should be valid") String email,

		Role role, String firstName, String lastName, String phoneNumber) {
}