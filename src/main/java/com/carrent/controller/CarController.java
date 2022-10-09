package com.carrent.controller;

import com.carrent.core.CarDto;
import com.carrent.facade.CarFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CarController {

    private final CarFacade carFacade;

    @PostMapping("/car")
    public Long createCar(@RequestBody CarDto carDto) {
        return carFacade.createCar(carDto);
    }

    @PutMapping("/car/status/{carId}")
    public Long updateCarRentStatus(@PathVariable Long carId, @RequestParam boolean rentStatus) {
        return carFacade.updateCarRentStatus(carId, rentStatus);
    }

    @PutMapping("/car/price/{carId}")
    public Long updateCarPrice(@PathVariable Long carId, @RequestParam Long price) {
        return carFacade.updateCarPrice(carId, price);
    }

    @DeleteMapping("/car")
    public void deleteCar(@RequestParam Long carId) {
        carFacade.deleteCar(carId);
    }
}
