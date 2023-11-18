package com.nicoesteban.BukinBackend.business;


import org.springframework.stereotype.Component;

@Component
public class BusinessDtoToBusinessMapper {

    public Business toBusiness(BusinessDTO businessDTO) {
        if (businessDTO == null) {
            return null;
        }

        Business business = new Business();
        business.setId(businessDTO.getId());
        business.setType(businessDTO.getType());
        business.setName(businessDTO.getBasicInfo().getName());
        business.setAddress(businessDTO.getBasicInfo().getAddress());
        business.setPhoneNumber(businessDTO.getBasicInfo().getPhoneNumber());
        business.setUrl(businessDTO.getUrl());
        business.setServices(businessDTO.getServices());

        return business;
    }

}
