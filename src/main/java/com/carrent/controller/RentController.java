package com.carrent.controller;

import com.carrent.core.RentDto;
import com.carrent.facade.RentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class RentController {

    private final RentFacade rentFacade;

    @PostMapping("/rent")
    public void createRent (@RequestBody RentDto rentDto) {
        rentFacade.createRent(rentDto);
    }

    @PutMapping("/rent/{rentId}")
    public void finishRent(@PathVariable Long rentId, @RequestParam LocalDate endDate) {
        rentFacade.finishRent(rentId, endDate);
    }
}
