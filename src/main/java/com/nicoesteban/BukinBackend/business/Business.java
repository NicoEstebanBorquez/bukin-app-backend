package com.nicoesteban.BukinBackend.business;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    @NotBlank
    private String name;
    //TODO Establecer relaciones OneToMany/ManyToMany.
    //private BusinessBasicInfo basicInfo;
    //private List<BusinessServiceInformation> services;
}



