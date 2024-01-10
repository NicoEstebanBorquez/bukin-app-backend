package com.nicoesteban.BukinBackend.business;

import com.nicoesteban.BukinBackend.businessService.BusinessService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class BusinessDTO {
    private Long id;

    @Schema( type = "string", example = "Peluquería")
    private String type;

    private BusinessBasicInfo basicInfo;

    @Schema( type = "string", example = "peluqueria-marcos")
    private String url;

    private Set<BusinessService> services = new HashSet<>();
}
