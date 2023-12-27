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

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BusinessController {

    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    BusinessDtoToBusinessMapper mapper;

    // √
    @GetMapping("businesses/{id}")
    public ResponseEntity<Business> getBusiness(@PathVariable Long id) {
        Optional<Business> business = businessRepository.findById(id);
        return business.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    // √
    @GetMapping("businesses/url/{url}")
    public ResponseEntity<Business> getBusinessByUrl(@PathVariable String url) {
        Optional<Business> business = businessRepository.findByUrl(url);
        return business.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    // √
    @GetMapping("/businesses")
    public ResponseEntity<List<Business>> getBusinesses() {
        List<Business> businesses = businessRepository.findAll();
        return !businesses.isEmpty() ? ResponseEntity.ok(businesses) : ResponseEntity.noContent().build();
    }

    //TODO - Comprobar si hay alguna forma de mejorar esto
    @PostMapping("/businesses")
    public ResponseEntity<Business> createBusiness(@RequestBody @Valid BusinessDTO businessDTO) {
        Business businessRequest = mapper.toBusiness(businessDTO);
        Business insertedBusiness = businessRepository.save(businessRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedBusiness);
    }

    //TODO - Comprobar si hay alguna forma de mejorar esto
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

    // √
    @DeleteMapping("businesses/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable Long id) {
        try {
            businessRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //  √
    //Get list of existing business URLs
    @GetMapping("/businesses/urls")
    public ResponseEntity<List<String>> getUrls() {
        List<String> urls = businessRepository.findUrls();
        return !urls.isEmpty() ? ResponseEntity.ok(urls) : ResponseEntity.noContent().build();
    }
}
