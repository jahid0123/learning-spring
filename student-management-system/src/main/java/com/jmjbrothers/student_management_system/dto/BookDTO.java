package com.jmjbrothers.student_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

	private String name;
	private String author;
	private String publisher;
	private Integer clazzId;

}
