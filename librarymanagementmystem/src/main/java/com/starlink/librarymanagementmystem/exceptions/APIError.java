package com.starlink.librarymanagementmystem.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIError {
	private Integer statusCode;
	private String message;
	private Date date;
	private String path;
	private HttpStatus httpstatus;

}
