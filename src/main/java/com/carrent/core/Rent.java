package com.carrent.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RENT")
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @OneToMany
    @JoinColumn(name = "USER_ID")
    private User userId;

    @OneToMany
    @JoinColumn(name = "CAR_ID")
    private Car carId;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;


}
