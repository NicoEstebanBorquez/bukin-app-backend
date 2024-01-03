package com.nicoesteban.BukinBackend.reservation.repository;

import com.nicoesteban.BukinBackend.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.businessIdentifier = ?1 ORDER BY date DESC, time DESC")
    Set<Reservation> findByBusinessId(Long businessId);

    @Query("SELECT r FROM Reservation r WHERE r.businessIdentifier = ?1 AND r.customerTelephoneNumber = ?2 ORDER BY date DESC")
    Set<Reservation> findByBusinessIdAndCustomerTelNumber(Long businessId, String  customerTelephoneNumber);

    @Query("SELECT r FROM Reservation r WHERE r.customerTelephoneNumber = ?1")
    Set<Reservation> findByCustomerTelNumber(String  customerTelephoneNumber);
}
