package com.nicoesteban.BukinBackend.business.repository;

import com.nicoesteban.BukinBackend.business.BusinessServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessServiceInfoRepository extends JpaRepository<BusinessServiceInfo, Long> {
}
