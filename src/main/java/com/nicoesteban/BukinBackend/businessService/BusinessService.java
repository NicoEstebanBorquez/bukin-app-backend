package com.nicoesteban.BukinBackend.businessService;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "business_services_info")
@Entity
public class BusinessService {
    //TODO - Añadir validación
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Schema( type = "string", example = "Corte de pelo caballero")
    private String description;

    @NotBlank
    @Positive
    @Schema( type = "string", example = "30")
    private String duration;

    @Schema( type = "string", example = "12")
    private String price;
}
