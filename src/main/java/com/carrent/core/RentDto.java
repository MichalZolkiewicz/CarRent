package com.carrent.core;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class RentDto {

    private final Long id;
    private final User userId;
    private final Car carId;
    private final LocalDate startDate;
    private final LocalDate endDate;

}
