package com.nicoesteban.BukinBackend.business;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class BusinessBasicInfo {
    @Schema( type = "string", example = "Peluquería Marcos")
    private String name;

    @Schema( type = "string", example = "Av. Isaac Peral, nº 5")
    private String address;

    @Schema( type = "string", example = "670340130")
    private String phoneNumber;
}