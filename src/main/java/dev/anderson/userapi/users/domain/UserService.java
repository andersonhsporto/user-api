package dev.anderson.userapi.users.domain;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserDto create(UserDto userDto) {
		UserEntity entity = UserDto.toEntity(userDto);
		
		userRepository.save(entity);
		return UserDto.fromEntity(entity);
	}

	public UserDto update(Long id, @Valid UserDto dto) {
		return userRepository.f
	}

}
