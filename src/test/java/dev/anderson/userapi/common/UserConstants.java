package dev.anderson.userapi.common;

import java.time.LocalDate;

import dev.anderson.userapi.users.domain.UserDto;
import dev.anderson.userapi.users.domain.UserEntity;

public class UserConstants {
	
	public static final UserDto VALID_INPUT_DTO = 
			UserDto.builder()
			.name("Name")
			.username("username-dto")
			.password("very-safe-password")
			.dateOfBirth(LocalDate.of(1999, 1, 1))
			.build();
	
	public static final UserEntity VALID_INPUT_ENTITY =
			UserEntity.builder()
				.name("Valid name")
				.username("Valid username")
				.dateOfBirth(LocalDate.of(1999, 1, 1))
				.build();

}
