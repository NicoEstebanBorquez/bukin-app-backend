package com.nicoesteban.BukinBackend.business.repository;


import com.nicoesteban.BukinBackend.business.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

    @Query("SELECT b FROM Business b where b.url = ?1")
    Optional<Business> findByUrl(String url);

    @Query("SELECT b.url FROM Business b")
    List<String> findUrls();
}
