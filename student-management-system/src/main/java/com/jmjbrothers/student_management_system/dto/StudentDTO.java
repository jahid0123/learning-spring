package com.jmjbrothers.student_management_system.dto;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	private String name;
	private String email;
	private Integer classId;
	private Integer roll;
	private List<Integer> bookIds;
	private String phone;
	private String address;
	private String gender;
	private Instant dob;

}
