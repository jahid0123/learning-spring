package com.jmjbrothers.student_management_system.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends CustomUser implements UserDetails {

	private static final List<GrantedAuthority> ROLE_USER = Collections
			.unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER"));

	public CustomUserDetails(CustomUser customUser) {
		super(customUser.getId(), customUser.getEmail(), customUser.getPassword());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return ROLE_USER;
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

}