package com.nicoesteban.BukinBackend.businessService.repository;

import com.nicoesteban.BukinBackend.businessService.BusinessService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessServiceRepository extends JpaRepository<BusinessService, Long> {
}
