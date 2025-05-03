package com.jmjbrothers.student_management_system.config;

import java.util.Date;

import javax.crypto.SecretKey;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.jmjbrothers.student_management_system.model.CustomUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenProvider {

	private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);



	//Generate Token 
	public String createToken(Authentication authentication) {
		CustomUserDetails userPrincipal = (CustomUserDetails) authentication.getPrincipal();

	

		return Jwts
				.builder()
				.setSubject(userPrincipal.getUsername())
				.claim("id", userPrincipal.getId())
				.claim("email", userPrincipal.getEmail())
				.claim("role", userPrincipal.getRole().name())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000))
				.signWith(secretKey)
				.compact();
	}
	
	
	//Extract username From Token----------
	public String getUsernameFromToken(String token) {
		Claims claims = Jwts
				.parserBuilder()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJws(token)
				.getBody();

		return claims.getSubject();
	}
	
	
	//Check token is valid or not
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder()
			.setSigningKey(secretKey)
			.build()
			.parseClaimsJws(token);
			
			return true;
		} catch (SecurityException ex) {
			log.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			log.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			log.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			log.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			log.error("JWT claims string is empty");
		}
		return false;
	}

	//Extract All Claims From Token....
	public Claims getClaimsFromToken(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
}