package com.nicoesteban.BukinBackend.business;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class BusinessDTO {

    private Long id;
    private String type;
    private BusinessBasicInfo businessBasicInfo;
    private Set<BusinessServiceInfo> services = new HashSet<>();

}
