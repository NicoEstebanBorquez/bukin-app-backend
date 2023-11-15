package com.nicoesteban.BukinBackend.business.controller;

import com.nicoesteban.BukinBackend.business.Business;
import com.nicoesteban.BukinBackend.business.BusinessDTO;
import com.nicoesteban.BukinBackend.business.BusinessDtoToBusinessMapper;
import com.nicoesteban.BukinBackend.business.repository.BusinessRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BusinessController {

    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    BusinessDtoToBusinessMapper mapper;

    @GetMapping("businesses/{id}")
    public ResponseEntity<Business> getBusiness(@PathVariable Long id) {
        Business business = businessRepository.findById(id).orElse(null);
        return business != null ? ResponseEntity.ok(business) : ResponseEntity.noContent().build();
    }

    @GetMapping("/businesses")
    public ResponseEntity<List<Business>> getBusinesses() {
        List<Business> businesses = new ArrayList<>();
        businessRepository.findAll().forEach(businesses::add);
        return businesses != null ? ResponseEntity.ok(businesses) : ResponseEntity.noContent().build();
    }

    @PostMapping("/businesses")
    public ResponseEntity<Business> createBusiness(@RequestBody @Valid BusinessDTO businessDTO) {
        Business businessRequest = mapper.toBusiness(businessDTO);
        Business insertedBusiness = businessRepository.save(businessRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedBusiness);
    }

    @PutMapping("/businesses")
    public ResponseEntity<Business> updateBusiness(@RequestBody @Valid BusinessDTO businessDTO) {
        Business businessRequest = mapper.toBusiness(businessDTO);
        Business editedBusiness = businessRepository.findById(businessRequest.getId()).orElse(null);
        if (editedBusiness != null) {
            editedBusiness.setType(businessRequest.getType());
            editedBusiness.setName(businessRequest.getName());
            editedBusiness.setAddress(businessRequest.getAddress());
            editedBusiness.setPhoneNumber(businessRequest.getPhoneNumber());
            //TODO
            //editedBusiness.setServices(business.getServices());
        }
        return ResponseEntity.ok(businessRepository.save(editedBusiness));
    }

    @DeleteMapping("businesses/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable Long id) {
        businessRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
