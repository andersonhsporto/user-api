package dev.anderson.userapi.users.domain;

import static org.junit.jupiter.api.Assertions.fail;
import static dev.anderson.userapi.common.UserConstants.VALID_INPUT_DTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.anderson.userapi.common.UserConstants;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;

//	@Test
//	void createUser_WithValidData_ReturnsUser() {
//		when(userRepository.save(VALID_INPUT_DTO))
//	}

}
