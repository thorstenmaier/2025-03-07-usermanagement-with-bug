package com.accenture.spring.user.service;

import com.accenture.spring.user.domain.User;
import com.accenture.spring.user.repository.LogEntryRepository;
import com.accenture.spring.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class) // kann entfallen, da in @SpringBootTest enthalten
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        assertEquals(3, users.size());
    }
}