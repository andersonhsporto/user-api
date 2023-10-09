package dev.anderson.userapi.users.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import dev.anderson.userapi.users.exceptions.UserNotFoundExcepton;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return super.handleMethodArgumentNotValid(ex, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	private ResponseEntity<Object> handleConflict(DataIntegrityViolationException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("The user already exists, try again with a unique username");
	}
	
	@ExceptionHandler(UserNotFoundExcepton.class)
	private ResponseEntity<Object> handleUserNotFound(UserNotFoundExcepton ex) {
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	}
}
