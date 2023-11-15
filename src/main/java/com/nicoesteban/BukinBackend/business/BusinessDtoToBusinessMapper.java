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
        business.setName(businessDTO.getBusinessBasicInfo().getName());
        business.setAddress(businessDTO.getBusinessBasicInfo().getAddress());
        business.setPhoneNumber(businessDTO.getBusinessBasicInfo().getPhoneNumber());
        business.setServices(businessDTO.getServices());

        return business;
    }

}
