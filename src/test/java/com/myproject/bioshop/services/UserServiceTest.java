package com.myproject.bioshop.services;

import com.myproject.bioshop.model.dto.UserRegisterForm;
import com.myproject.bioshop.model.entity.User;
import com.myproject.bioshop.repository.UserRepository;
import com.myproject.bioshop.service.RoleService;
import com.myproject.bioshop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private PasswordEncoder mockPasswordEncoder;

    @Mock
    private ModelMapper mockModelMapper;

    @Mock
    private RoleService mockRoleService;

    @Mock
    private UserRepository mockUserRepository;

    private UserService toTest;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @BeforeEach
    public void setUp() {
        toTest = new UserService(
                mockUserRepository,
                mockModelMapper,
                mockPasswordEncoder,
                mockRoleService);
    }

    @Test
    void testUserRegistration() {
        String encodedPassword = "encodedPassword";
        String testPassword = "testPassword";
        String testEmail = "testEmail";
        String testFirstName = "Test";
        String testLastName = "Testov";

        UserRegisterForm testRegisterDto = new UserRegisterForm()
                .setEmail(testEmail)
                .setFirstName(testFirstName)
                .setLastName(testLastName)
                .setPassword(testPassword);

        when(mockPasswordEncoder
                .encode(testRegisterDto.getPassword()))
                .thenReturn(encodedPassword);


        toTest.registerUser(testRegisterDto);


        verify(mockUserRepository).saveAndFlush(userArgumentCaptor.capture());

        User actualSavedUser = userArgumentCaptor.getValue();

        assertEquals(testRegisterDto.getEmail(), actualSavedUser.getEmail());
        assertEquals(encodedPassword, actualSavedUser.getPassword());
    }


}
