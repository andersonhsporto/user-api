package dev.anderson.userapi.users.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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

    @JsonProperty("username") 
    String username,

    @NotEmpty 
    @JsonInclude(Include.NON_NULL) 
    @JsonProperty("password") 
    String password,

    @NotNull 
    @JsonProperty("dateOfBirth") 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") 
    LocalDate dateOfBirth,

    @JsonInclude(Include.NON_NULL) 
    LocalDateTime createdAt,

    @JsonInclude(Include.NON_NULL) 
    LocalDateTime updatedAt
    ) {
  public static UserEntity toEntity(UserDto dto) {
    return UserEntity.builder().name(dto.name).username(dto.username).password(dto.password)
        .dateOfBirth(dto.dateOfBirth).build();
  }

  public static UserDto fromEntity(UserEntity entity) {
    return UserDto.builder().id(entity.getId()).name(entity.getName())
        .username(entity.getUsername()).dateOfBirth(entity.getDateOfBirth())
        .createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();
  }

}
