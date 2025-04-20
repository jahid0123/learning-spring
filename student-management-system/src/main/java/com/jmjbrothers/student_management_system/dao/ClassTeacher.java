package com.jmjbrothers.student_management_system.dao;

import lombok.Getter;

@Getter

public class ClassTeacher {

	private String className;
	private Integer roomNumber;
	private String teacherName;
	private String teacherEmail;

	public ClassTeacher(String className, Integer roomNumber, String teacherName, String teacherEmail) {
		this.className = className;
		this.roomNumber = roomNumber;
		this.teacherName = teacherName;
		this.teacherEmail = teacherEmail;
	}

}
