package com.nicoesteban.BukinBackend.reservation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
/*
Shortcut for:
    @ToString
    @EqualsAndHashCode
    @Getter on all fields
    @Setter on all non-final fields
    @RequiredArgsConstructor
*/
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO - Añadir validación
    private Long businessIdentifier;
    private String service;
    private String employee;
    private LocalDate date;
    private String time;
    private String customerName;
    private String customerTelephoneNumber;
}
