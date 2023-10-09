package dev.anderson.userapi.users.domain;

import java.time.LocalDate;

import org.springframework.util.StringUtils;

public class UserMapper {
	public static UserEntity updateFromDto(UserDto dto, UserEntity entity) {
		final String name = StringUtils.hasText(dto.name()) ? dto.name() : entity.getName();
		final String username = StringUtils.hasText(dto.username()) ? dto.username() : entity.getUsername();
		final LocalDate dateOfBirth = dto.dateOfBirth() != null ? dto.dateOfBirth() : entity.getDateOfBirth();
		
		return new UserEntity(
				entity.getId(),
				name,
				username,
				entity.getPassword(),
				dateOfBirth,
				entity.getCreatedAt(),
				entity.getUpdatedAt());
	
	}
}
