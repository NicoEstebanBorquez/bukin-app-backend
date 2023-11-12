package com.nicoesteban.BukinBackend.business.controller;

import com.nicoesteban.BukinBackend.business.Business;
import com.nicoesteban.BukinBackend.business.service.BusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/business")
public class BusinessController {

    private final BusinessService businessService;

    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusiness(@PathVariable Long id) {
        Business business = businessService.retrieveBusiness(id);
        return business != null ? ResponseEntity.ok(business) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Business>> getBusinesses() {
        List<Business> businesses = businessService.retrieveBusinesses();
        return businesses != null ? ResponseEntity.ok(businesses) : ResponseEntity.noContent().build();
    }

    //TODO Añadir Validación.
    @PostMapping
    public ResponseEntity<Business> postBusiness(@RequestBody Business business) {
        Business insertedBusiness = businessService.insertBusiness(business);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedBusiness);
    }

    @PutMapping
    public ResponseEntity<Business> updateBusiness(@RequestBody Business business) {
        businessService.updateBusiness(business);
        return ResponseEntity.ok(business);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
        return ResponseEntity.noContent().build();
    }
}
