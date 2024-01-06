package com.nicoesteban.BukinBackend.reservation;

import io.swagger.v3.oas.annotations.media.Schema;
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
    //TODO - Añadir validación
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema( type = "string", example = "16")
    private Long businessIdentifier;

    @Schema( type = "string", example = "Corte pelo caballero")
    private String service;

    @Schema( type = "string", example = "Marcos")
    private String employee;

    @Schema( type = "string", example = "2024-01-25")
    private LocalDate date;

    @Schema( type = "string", example = "17:30")
    private String time;

    @Schema( type = "string", example = "Juan García")
    private String customerName;

    @Schema( type = "string", example = "666555444")
    private String customerTelephoneNumber;
}
