package com.jmjbrothers.student_management_system.dto;

import java.util.List;

public record ErrorResponse(Integer httpStatus, String exception, String message, List<FieldError> fieldErrors) {
}
