package com.myproject.bioshop.services;

import com.myproject.bioshop.model.entity.User;
import com.myproject.bioshop.repository.UserRepository;
import com.myproject.bioshop.service.ApplicationUserDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {


    private ApplicationUserDetailsService toTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        toTest = new ApplicationUserDetailsService(
                mockUserRepository
        );
    }

    @Test
    void testUserFound() {

        User user = new User()
                .setEmail("ppachalov@abv.bg")
                .setPassword("zasada")
                .setAuthorities(List.of());

        when(mockUserRepository.findUserByEmail("ppachalov@abv.bg"))
                .thenReturn(Optional.of(user));

        UserDetails adminDetails = toTest.loadUserByUsername("ppachalov@abv.bg");

        Assertions.assertNotNull(adminDetails);
        Assertions.assertEquals("ppachalov@abv.bg", adminDetails.getUsername());
        Assertions.assertEquals(user.getPassword(), adminDetails.getPassword());

        Assertions.assertEquals(3, adminDetails.getAuthorities().size(), "The authorities are supposed to be 3");
/*        assertRole(adminDetails.getAuthorities(), "ROLE_ADMIN");
        assertRole(adminDetails.getAuthorities(), "ROLE_MODERATOR");
        assertRole(adminDetails.getAuthorities(), "ROLE_USER");*/
    }

/*    private String assertRole(Collection<? extends GrantedAuthority> authorities
            , String role) {
        authorities
                .stream()
                .filter(r -> role.equals(r.getAuthority()))
                .findAny()
                .orElseThrow(() -> Assertions.fail("Role " + role + " not found!"));
    }*/

    @Test
    void testUserNotFound() {
        assertThrows(UsernameNotFoundException.class,
                () -> {
            toTest.loadUserByUsername("non-existent@abv.bg");
                });
    }

}
