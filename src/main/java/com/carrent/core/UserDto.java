package com.carrent.core;

import lombok.*;

@Builder
@Getter
public class UserDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
}
