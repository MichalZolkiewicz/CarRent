package com.carrent.facade;

import com.carrent.core.Car;
import com.carrent.repositories.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarFacadeTest {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarFacade carFacade;

    @Test
    public void testCreateCar() {
        Car car = new Car();

        carRepository.save(car);
        long carId = car.getId();

        Car testCar = carRepository.findById(carId);

        assertEquals(testCar.getId(), carId);

        carRepository.deleteById(carId);
    }

    @Test
    public void testUpdateCarRentStatus() {
        Car car = new Car();
        boolean rentStatus = true;

        carRepository.save(car);
        long newCarStatus = carFacade.updateCarRentStatus(car.getId(), rentStatus);
        Car updatedCar = carRepository.findById(newCarStatus);

        assertTrue(updatedCar.isRented());

        carRepository.deleteById(newCarStatus);
    }

    @Test
    public void testUpdateCarPrice() {
        Car car = new Car();
        car.setPrice(100L);


        carRepository.save(car);
        Long newPrice = 200L;
        Long carId = car.getId();
        long updatedPriceCarId = carFacade.updateCarPrice(carId, newPrice);

        Car carWithUpdatedPrice = carRepository.findById(updatedPriceCarId);

        assertEquals(newPrice, carWithUpdatedPrice.getPrice());

        carRepository.deleteById(updatedPriceCarId);

    }

    @Test
    public void testDeleteCar() {
        Car car = new Car();

        carRepository.save(car);
        Long carId = car.getId();

        assertTrue(carRepository.existsById(carId));

        carFacade.deleteCar(carId);

        assertFalse(carRepository.existsById(carId));
    }
}
