package com.carrent.mappers;

import com.carrent.core.Car;
import com.carrent.core.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarMapper {

    public Car mapToCar(CarDto carDto) {
        return new Car(carDto.getId(), carDto.getPrice(), carDto.getRentStatus());
    }

    public CarDto mapToCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .price(car.getPrice())
                .rentStatus(car.getRentStatus())
                .build();
    }
}
