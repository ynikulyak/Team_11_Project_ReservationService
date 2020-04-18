package cst438.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cst438.domain.*;
import cst438.service.ReservationService;

@RestController
public class ReservationRestController {

   @Autowired
   private ReservationService reservationService;

   @GetMapping("/api/reservations/v1/{reservationId}")
   public ReservationInfo getReservation(@PathVariable("reservationId") int idReservation) {
      Optional<ReservationInfo> reservation = reservationService.getReservationInfoById(idReservation);
      if (reservation.isPresent()) {
         return reservation.get();
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   }

   @PostMapping(path = "/api/reservation/v1/create", consumes = "application/json", produces = "application/json")
   public Reservation create(@RequestBody Reservation reservation) {
      return reservationService.create(reservation);
   }
}
