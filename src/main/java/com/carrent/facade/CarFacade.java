package com.carrent.facade;

import com.carrent.core.Car;
import com.carrent.core.CarDto;
import com.carrent.mappers.CarMapper;
import com.carrent.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarFacade {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public Long createCar(CarDto carDto) {
        Car car = carMapper.mapToCar(carDto);
        carRepository.save(car);
        return car.getId();
    }

    public Long updateCarRentStatus(final long carId, boolean rentStatus) {
        Car car = carRepository.findById(carId);
        car.setRented(rentStatus);

        Car newCarRentStatus = carRepository.save(car);
        carMapper.mapToCarDto(newCarRentStatus);
        return newCarRentStatus.getId();
    }

    public Long updateCarPrice(final long carId, Long price) {
        Car car = carRepository.findById(carId);
        car.setPrice(price);

        Car newPriceCar = carRepository.save(car);
        carMapper.mapToCarDto(newPriceCar);
        return newPriceCar.getId();
    }

    public void deleteCar(final Long carId) {
        carRepository.deleteById(carId);
    }
}
