package com.starlink.librarymanagementmystem.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(BookDataNotSaved.class)
public ResponseEntity<APIError>BookDataNotSavedHandler(BookDataNotSaved e,HttpServletRequest request){
	APIError error = new APIError();
	error.setDate(new Date());
	error.setHttpstatus(HttpStatus.BAD_REQUEST);
	error.setStatusCode(HttpStatus.BAD_REQUEST.value());
	error.setMessage(e.getMessage());
	error.setPath(request.getRequestURI());
	return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
	}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>>MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e,HttpServletRequest request){
	Map<String, String>error= new HashMap<String, String>();
	e.getBindingResult().getAllErrors().forEach((er)->{
		String fieldName = ((FieldError)er).getField();
		String msg = er.getDefaultMessage();
		error.put(fieldName, msg);
	});
	return new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(NoAnyBookAvailable.class)
public ResponseEntity<APIError>NoAnyBookAvailableHandler(NoAnyBookAvailable e,HttpServletRequest request){
	APIError error = new APIError();
	error.setDate(new Date());
	error.setHttpstatus(HttpStatus.NOT_FOUND);
	error.setStatusCode(HttpStatus.NOT_FOUND.value());
	error.setMessage(e.getMessage());
	error.setPath(request.getRequestURI());
	return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
}
	

	@ExceptionHandler(BookNameNotFound.class)
	public ResponseEntity<APIError> bookNameResponseEntity(BookNameNotFound e,HttpServletRequest request)
	{
		APIError error=new APIError();
		
		error.setDate(new Date());
		error.setHttpstatus(HttpStatus.NOT_FOUND);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(BookIdNotFound.class)
	public ResponseEntity<APIError> bookIdNotFound(BookIdNotFound e, HttpServletRequest request)
	{
		
		APIError error=new APIError();
		
		error.setDate(new Date());
		error.setHttpstatus(HttpStatus.NOT_FOUND);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<APIError> authorNotFoundException(AuthorNotFoundException e, HttpServletRequest request)
	{
		APIError error=new APIError();
		
		error.setDate(new Date());
		error.setHttpstatus(HttpStatus.NOT_FOUND);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookNotFoundForUpdateException.class)
	public ResponseEntity<APIError> bookNotFoundForUpdateException(BookNotFoundForUpdateException e, HttpServletRequest request)
	{
		APIError error=new APIError();
		
		error.setDate(new Date());
		error.setHttpstatus(HttpStatus.NOT_FOUND);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminNotSavedException.class)
	public ResponseEntity<APIError> AdminNotSavedExceptionHandler(AdminNotSavedException e,HttpServletRequest request)
	
	{
		APIError error = new APIError();
		error.setDate(new Date());
		error.setHttpstatus(HttpStatus.BAD_REQUEST);
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(IdNotFoundForDeleteException.class)
	public ResponseEntity<APIError> idNotFoundForDeleteException(IdNotFoundForDeleteException e, HttpServletRequest request)
	{
		APIError error=new APIError();
		
		error.setDate(new Date());
		error.setHttpstatus(HttpStatus.NOT_FOUND);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserNameAndPassword.class)
	public ResponseEntity<APIError> InvalidUserNameAndPasswordExceptionHandler(InvalidUserNameAndPassword e,HttpServletRequest request)
	{
		APIError error = new APIError();
		error.setDate(new Date());
		error.setHttpstatus(HttpStatus.NOT_FOUND);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}

}
