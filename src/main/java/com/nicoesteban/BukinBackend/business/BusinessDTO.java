package com.nicoesteban.BukinBackend.business;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class BusinessDTO {

    private Long id;
    private String type;
    private BusinessBasicInfo basicInfo;
    private String url;
    private Set<BusinessServiceInfo> services = new HashSet<>();

}
