package com.jmjbrothers.student_management_system.config;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class InstantDeserializer extends JsonDeserializer<Instant> {

	@Override
	public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		// TODO Auto-generated method stub
		String date = p.getText();
		return LocalDate.parse(date).atStartOfDay().toInstant(ZoneOffset.UTC);
	}

}
