package com.carrent.controller;

import com.carrent.core.UserDto;
import com.carrent.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/user")
    public Long createUser(@RequestBody UserDto userDto) {
        return userFacade.createUser(userDto);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userFacade.deleteUser(userId);
    }
}
