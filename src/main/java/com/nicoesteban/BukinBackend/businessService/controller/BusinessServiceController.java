package com.nicoesteban.BukinBackend.businessService.controller;

import com.nicoesteban.BukinBackend.business.Business;
import com.nicoesteban.BukinBackend.businessService.BusinessService;
import com.nicoesteban.BukinBackend.business.repository.BusinessRepository;
import com.nicoesteban.BukinBackend.businessService.repository.BusinessServiceRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BusinessServiceController {

    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    BusinessServiceRepository businessServiceRepository;

    @GetMapping("businesses/{id}/services")
    public ResponseEntity<Set<BusinessService>> getServicesByBusinessId(@PathVariable Long id) {
        return businessRepository.findById(id)
                .map(business -> ResponseEntity.ok(business.getServices()))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("businesses/{id}/services")
    public ResponseEntity<List<BusinessService>> createServices(@PathVariable Long id, @RequestBody @Valid List<BusinessService> servicesRequest) {
        Business business = businessRepository.findById(id).orElse(null);
        if (business != null) {
            servicesRequest.forEach(service -> business.getServices().add(service));
            businessRepository.save(business);
            return ResponseEntity.status(HttpStatus.CREATED).body(servicesRequest);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("business-services/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        try {
            businessServiceRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
