package com.te.contactsystem.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	private boolean data;
	private Object obj;
	private String msg;
	private HttpStatus http;
}
