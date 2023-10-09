package dev.anderson.userapi.users.domain;

import org.springframework.stereotype.Service;

import dev.anderson.userapi.users.exceptions.UserNotFoundExcepton;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	private final UserMapper userMapper;
	
	public UserDto create(UserDto userDto) {
		UserEntity entity = UserDto.toEntity(userDto);
		
		userRepository.save(entity);
		return UserDto.fromEntity(entity);
	}

	public UserDto update(Long id, @Valid UserDto dto) throws UserNotFoundExcepton {
		return userRepository.findById(id)
				.map(user -> userMapper.updateFromDto(dto, user))
				.map(userRepository::save)
				.map(UserDto::fromEntity)
				.orElseThrow(UserNotFoundExcepton::new);
	}

	public UserDto get(Long id) throws UserNotFoundExcepton {
		return userRepository.findById(id)
				.map(UserDto::fromEntity)
				.orElseThrow(UserNotFoundExcepton::new);
	}

}
