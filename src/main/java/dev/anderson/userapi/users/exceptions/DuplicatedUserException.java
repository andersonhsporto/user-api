package dev.anderson.userapi.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatedUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicatedUserException() {
		super("This username already exists");
	}

}
