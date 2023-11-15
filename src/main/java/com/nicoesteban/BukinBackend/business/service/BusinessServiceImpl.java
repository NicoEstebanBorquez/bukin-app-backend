package com.nicoesteban.BukinBackend.business.service;


import com.nicoesteban.BukinBackend.business.Business;
import com.nicoesteban.BukinBackend.business.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;

    @Override
    public Business retrieveBusiness(Long id) {
        return businessRepository.findById(id).orElse(null);
    }

    @Override
    public List<Business> retrieveBusinesses() {
        List<Business> businesses = new ArrayList<>();
        businessRepository.findAll().forEach(businesses::add);
        return businesses;
    }

    @Override
    public Business insertBusiness(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public Business updateBusiness(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}
