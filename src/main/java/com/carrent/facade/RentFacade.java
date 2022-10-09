package com.carrent.facade;

import com.carrent.core.Car;
import com.carrent.core.Rent;
import com.carrent.core.RentDto;
import com.carrent.mappers.RentMapper;
import com.carrent.repositories.RentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RentFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(RentFacade.class);
    private static final String FREE = "Free";
    private static final String RENTED = "Rented";
    private final RentRepository rentRepository;
    private final RentMapper rentMapper;

    public Long createRent(RentDto rentDto) {
        Rent rent = rentMapper.mapToRent(rentDto);
        Car car = rent.getCarId();

        if(car.getRentStatus() == FREE) {
            car.setRentStatus(RENTED);
            rentRepository.save(rent);

        }else {
            LOGGER.error("CAR IS ALREADY RENTED");
        }

        return rent.getId();
    }

    public void finishRent(final long rentId, LocalDate endDate) {
        Rent rent = rentRepository.findById(rentId);
        rent.setEndDate(endDate);
        String carStatus = "free";
        rent.getCarId().setRentStatus(carStatus);
    }
}
