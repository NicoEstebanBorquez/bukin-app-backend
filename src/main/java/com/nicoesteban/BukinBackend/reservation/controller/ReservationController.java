package com.nicoesteban.BukinBackend.reservation.controller;

import com.nicoesteban.BukinBackend.business.Business;
import com.nicoesteban.BukinBackend.business.repository.BusinessRepository;
import com.nicoesteban.BukinBackend.reservation.Reservation;
import com.nicoesteban.BukinBackend.reservation.repository.ReservationRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("businesses/{id}/reservations/{customerTelephoneNumber}")
    public ResponseEntity<Set<Reservation>> getReservationsByCustomerAndBusiness(@PathVariable Long id, @PathVariable String customerTelephoneNumber) {
        Set<Reservation> reservations = reservationRepository.findByBusinessIdAndCustomerTelNumber(id, customerTelephoneNumber);
        return !reservations.isEmpty() ? ResponseEntity.ok(reservations) : ResponseEntity.noContent().build();
    }

    @GetMapping("businesses/{id}/reservations")
    public ResponseEntity<Set<Reservation>> getReservationsByBusinessId(@PathVariable Long id) {
        Set<Reservation> reservations = reservationRepository.findByBusinessId(id);
        return !reservations.isEmpty() ? ResponseEntity.ok(reservations) : ResponseEntity.noContent().build();
    }

    /*
        Este método hace lo mismo que los dos anteriores. Lo he dividido en dos porque creo que es mejor mantener
        separadas estas funcionalidades.
    */
    /*@GetMapping("businesses/{id}/reservations")
    public ResponseEntity<Set<Reservation>> getReservations(@PathVariable Long id, @RequestParam(value = "customer", required = false) String customerTelephoneNumber) {
        //Devuelve las reservas que un cliente tiene en un Business concreto
        if(customerTelephoneNumber != null){
            Set<Reservation> reservations = reservationRepository.findByBusinessIdAndCustomerTelNumber(id, customerTelephoneNumber);
            return !reservations.isEmpty() ? ResponseEntity.ok(reservations) : ResponseEntity.noContent().build();
        }
        //Devuelve todas las reservas del Business
        return businessRepository.findById(id)
                .map(business -> ResponseEntity.ok(business.getReservations()))
                .orElse(ResponseEntity.noContent().build());
    }*/

    @PostMapping("businesses/{id}/reservations")
    public ResponseEntity<Reservation> createReservation(@PathVariable Long id, @RequestBody @Valid Reservation reservationRequest) {
        Business business = businessRepository.findById(id).orElse(null);
        if (business != null) {
            business.getReservations().add(reservationRequest);
            businessRepository.save(business);
            return ResponseEntity.status(HttpStatus.CREATED).body(reservationRequest);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("reservations/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        try {
            reservationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
