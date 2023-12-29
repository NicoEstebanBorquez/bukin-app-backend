package com.nicoesteban.BukinBackend.business.controller;

import com.nicoesteban.BukinBackend.business.Business;
import com.nicoesteban.BukinBackend.business.BusinessServiceInfo;
import com.nicoesteban.BukinBackend.business.repository.BusinessRepository;
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
public class BusinessServiceInfoController {

    @Autowired
    BusinessRepository businessRepository;

    @GetMapping("businesses/{id}/services")
    public ResponseEntity<Set<BusinessServiceInfo>> getServicesByBusinessId(@PathVariable Long id) {
        return businessRepository.findById(id)
                .map(business -> ResponseEntity.ok(business.getServices()))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("businesses/{id}/services")
    public ResponseEntity<List<BusinessServiceInfo>> createServices(@PathVariable Long id, @RequestBody @Valid List<BusinessServiceInfo> servicesRequest) {
        Business business = businessRepository.findById(id).orElse(null);
        if (business != null) {
            servicesRequest.forEach(service -> business.getServices().add(service));
            businessRepository.save(business);
            return ResponseEntity.status(HttpStatus.CREATED).body(servicesRequest);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    //TODO - Añadir método que elimine un BusinessServiceInfo
}
