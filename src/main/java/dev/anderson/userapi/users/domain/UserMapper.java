package dev.anderson.userapi.users.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "password", ignore = true)
	UserEntity updateFromDto(UserDto dto, @MappingTarget UserEntity entity);
}
