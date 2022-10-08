package com.carrent.core;

import lombok.*;

@Builder
@Getter
public class CarDto {

    private final Long id;
    private final Long price;
    private final String rentStatus;
}
