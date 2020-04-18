package cst438.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cst438.domain.Passenger;
import cst438.service.PassengerService;

@RestController
public class PassengerRestController {

   @Autowired
   private PassengerService passengerService;

   @GetMapping("/api/passenger/v1/{id}")
   public Passenger getPassengerById(@PathVariable("id") Long id) {

      Optional<Passenger> passengerInfo = passengerService.getPassengerById(id);
      // return passenger object in form of json if object present
      if (passengerInfo.isPresent()) {
         return passengerInfo.get();
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   }
   
   @GetMapping("/api/passenger/v1/email/{email}")
   public Passenger getPassengerByEmail(@PathVariable("email") String email) {

      Optional<Passenger> passengerInfo = passengerService.getPassengerByEmail(email);
      // return passenger object in form of json if object present
      if (passengerInfo.isPresent()) {
         return passengerInfo.get();
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   }
}
