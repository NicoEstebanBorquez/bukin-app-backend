package com.nicoesteban.BukinBackend.business.repository;


import com.nicoesteban.BukinBackend.business.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

}
