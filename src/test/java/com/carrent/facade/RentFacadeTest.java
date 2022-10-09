package com.carrent.facade;

import com.carrent.core.Car;
import com.carrent.core.RentDto;
import com.carrent.core.User;
import com.carrent.repositories.CarRepository;
import com.carrent.repositories.RentRepository;
import com.carrent.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class RentFacadeTest {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentFacade rentFacade;

    @Test
    public void testCreateRent() {
        User user = new User();
        Car car = new Car();

        userRepository.save(user);
        carRepository.save(car);

        RentDto rentDto = RentDto.builder()
                .user(user)
                .car(car)
                .build();

        rentFacade.createRent(rentDto);
        boolean carRentStatus = car.isRented();
        boolean expectedRentStatus = true;

        assertEquals(expectedRentStatus, carRentStatus);

        userRepository.deleteById(user.getId());
        carRepository.deleteById(car.getId());
        rentRepository.deleteAll();
    }
}
