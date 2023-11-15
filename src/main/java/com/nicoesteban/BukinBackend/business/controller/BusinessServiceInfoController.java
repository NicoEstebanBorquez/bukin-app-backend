package com.nicoesteban.BukinBackend.business.controller;

import com.nicoesteban.BukinBackend.business.Business;
import com.nicoesteban.BukinBackend.business.BusinessServiceInfo;
import com.nicoesteban.BukinBackend.business.repository.BusinessRepository;
import com.nicoesteban.BukinBackend.business.repository.BusinessServiceInfoRepository;
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
public class BusinessServiceInfoController {

    @Autowired
    BusinessRepository businessRepository;

    @Autowired
    BusinessServiceInfoRepository businessServiceInfoRepository;

    @GetMapping("businesses/{id}/services")
    public ResponseEntity<List<BusinessServiceInfo>> getServicesByBusinessId(@PathVariable Long id) {
        Business business = businessRepository.findById(id).orElse(null);
        List<BusinessServiceInfo> services = new ArrayList<>();
        services.addAll(business.getServices());
        return business != null ? ResponseEntity.ok(services) : ResponseEntity.noContent().build();
    }

    @PostMapping("businesses/{id}/services")
    public ResponseEntity<BusinessServiceInfo> createService(@PathVariable Long id, @RequestBody @Valid BusinessServiceInfo serviceRequest) {
        BusinessServiceInfo service = businessRepository.findById(id).map(business -> {
            business.getServices().add(serviceRequest);
            return businessServiceInfoRepository.save(serviceRequest);
        }).orElse(null);

        return ResponseEntity.status(HttpStatus.CREATED).body(service);
    }

    //TODO Crear otro método (o modificar este) para que se pueda hacer un POST de una lista de servicios
}
