package com.nicoesteban.BukinBackend.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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



