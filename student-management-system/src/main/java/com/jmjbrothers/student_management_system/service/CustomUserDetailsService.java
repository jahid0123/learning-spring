package com.jmjbrothers.student_management_system.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jmjbrothers.student_management_system.model.CustomUser;
import com.jmjbrothers.student_management_system.model.CustomUserDetails;
import com.jmjbrothers.student_management_system.repository.CustomUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final CustomUserRepository userRepository;

	public CustomUserDetailsService(CustomUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUser customUser = this.userRepository.findCustomUserByEmail(username);
		if (customUser == null) {
			throw new UsernameNotFoundException("username " + username + " is not found");
		}
		return new CustomUserDetails(customUser);
	}

}