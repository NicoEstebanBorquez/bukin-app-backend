package com.nicoesteban.BukinBackend.business;

import com.nicoesteban.BukinBackend.businessService.BusinessService;
import com.nicoesteban.BukinBackend.reservation.Reservation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "businesses")
public class Business {
    //TODO - Añadir validación
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Schema( type = "string", example = "Peluquería")
    private String type;

    @Schema( type = "string", example = "Peluquería Marcos")
    private String name;

    @Schema( type = "string", example = "Avda. Isaac Peral, nº 5")
    private String address;

    @Schema( type = "string", example = "670340130")
    private String phoneNumber;

    @Schema( type = "string", example = "peluqueria-marcos")
    private String url;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "business_id")
    private Set<BusinessService> services = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "business_id")
    private Set<Reservation> reservations = new HashSet<>();
}



