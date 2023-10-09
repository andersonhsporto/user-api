package dev.anderson.userapi.users.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserDto(

		@JsonProperty("id") 
		Long id,

		@NotEmpty 
		@JsonProperty("name") 
		String name,

		@NotEmpty 
		@JsonProperty("username") 
		String username,

		@NotEmpty 
		@JsonIgnore
		@JsonProperty("password")
		String password,

		@NotNull 
		@JsonProperty("dateOfBirth") 
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") 
		LocalDate dateOfBirth) {

	public static UserEntity toEntity(UserDto dto) {
		return UserEntity.builder()
				.name(dto.name)
				.username(dto.username)
				.password(dto.password)
				.dateOfBirth(dto.dateOfBirth)
				.build();
	}

	public static UserDto fromEntity(UserEntity entity) {
		return UserDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.username(entity.getUsername())
				.dateOfBirth(entity.getDateOfBirth())
				.build();
	}

}
