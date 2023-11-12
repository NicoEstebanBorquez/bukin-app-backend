package com.nicoesteban.BukinBackend.business.service;

import com.nicoesteban.BukinBackend.business.Business;

import java.util.List;

public interface BusinessService {

    Business retrieveBusiness(Long id);

    List<Business> retrieveBusinesses();

    Business insertBusiness(Business business);

    Business updateBusiness(Business business);

    void deleteBusiness(Long id);

}
