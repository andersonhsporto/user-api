package dev.anderson.userapi.users.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "password", ignore = true)
	UserEntity updateFromDto(UserDto dto, @MappingTarget UserEntity entity);
}
