package com.carrent.mappers;

import com.carrent.core.Rent;
import com.carrent.core.RentDto;
import org.springframework.stereotype.Service;

@Service
public class RentMapper {

    public Rent mapToRent(RentDto rentDto) {
        return new Rent(rentDto.getId(), rentDto.getUser(), rentDto.getCar(), rentDto.getStartDate(), rentDto.getEndDate());
    }

    public RentDto mapToRentDto(Rent rent) {
        return RentDto.builder()
                .id(rent.getId())
                .user(rent.getUser())
                .car(rent.getCar())
                .startDate(rent.getStartDate())
                .endDate(rent.getEndDate())
                .build();
    }
}
