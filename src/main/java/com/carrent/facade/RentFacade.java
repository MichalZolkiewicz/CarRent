package com.carrent.facade;

import com.carrent.core.Rent;
import com.carrent.core.RentDto;
import com.carrent.mappers.RentMapper;
import com.carrent.repositories.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RentFacade {

    private final RentRepository rentRepository;
    private final RentMapper rentMapper;

    public Long createRent(RentDto rentDto) {
        Rent rent = rentMapper.mapToRent(rentDto);
        rentRepository.save(rent);
        return rent.getId();
    }

    public void finishRent(final long rentId, LocalDate endDate) {
        Rent rent = rentRepository.findById(rentId);
        rent.setEndDate(endDate);
        String carStatus = "free";
        rent.getCarId().setRentStatus(carStatus);
    }
}
