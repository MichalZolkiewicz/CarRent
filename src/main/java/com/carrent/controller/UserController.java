package com.carrent.controller;

import com.carrent.core.UserDto;
import com.carrent.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/user")
    public Long createUser(@RequestBody UserDto userDto) {
        return userFacade.createUser(userDto);
    }
}
