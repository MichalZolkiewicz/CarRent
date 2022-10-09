package com.carrent.facade;

import com.carrent.core.User;
import com.carrent.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserFacadeTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFacade userFacade;

    @Test
    public void testCreateUser() {
        User user = new User();

        userRepository.save(user);
        long userId = user.getId();

        User testUser = userRepository.findById(userId);

        assertEquals(userId, testUser.getId());

        userRepository.deleteById(userId);
    }

    @Test
    public void testDeleteUser() {
        User user = new User();

        userRepository.save(user);
        long userId = user.getId();

        assertTrue(userRepository.existsById(userId));

        userFacade.deleteUser(userId);

        assertFalse(userRepository.existsById(userId));
    }
}
