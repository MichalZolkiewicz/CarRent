package com.carrent.mappers;

import com.carrent.core.Rent;
import com.carrent.core.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentMapper {

    public Rent mapToRent(RentDto rentDto) {
        return new Rent(rentDto.getId(), rentDto.getUserId(), rentDto.getCarId(), rentDto.getStartDate(), rentDto.getEndDate());
    }

    public RentDto mapToRentDto(Rent rent) {
        return RentDto.builder()
                .id(rent.getId())
                .userId(rent.getUserId())
                .carId(rent.getCarId())
                .startDate(rent.getStartDate())
                .endDate(rent.getEndDate())
                .build();
    }

    public List<RentDto> mapToRentDtoList(List<Rent> rentList) {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
