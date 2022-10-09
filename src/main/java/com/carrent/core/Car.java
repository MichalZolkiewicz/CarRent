package com.carrent.core;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "RENT_STATUS")
    private boolean isRented;

    public Car(Long id, Long price, boolean isRented) {
        this.id = id;
        this.price = price;
        this.isRented = isRented;
    }
}
