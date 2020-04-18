package cst438.service;

import java.util.Optional;

import javax.persistence.Column;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cst438.domain.Passenger;
import cst438.domain.PassengerRepository;

@Service
public class PassengerService {

   private static final Logger log = LoggerFactory.getLogger(BookingFlightService.class);

   @Autowired
   private PassengerRepository passengerRepository;

   public Optional<Passenger> getPassengerById(long id) {

      // find passenger by id from db from table passenger
      Optional<Passenger> passengerOptional = passengerRepository.findById(id);
      // if no airport was found
      if (!passengerOptional.isPresent()) {
         log.warn("Passenger for {} id was not found", id);
         return Optional.empty();
      }

      // take airport object
      Passenger passenger = passengerOptional.get();

      String firstName = passenger.getFirstName();
      String lastName = passenger.getLastName();
      String email = passenger.getEmail();
      String username = passenger.getUsername();
      byte[] passwordHashCode = passenger.getPasswordHashCode();

      return Optional.of(new Passenger(passenger.getId(), firstName, lastName, email, username, passwordHashCode));
   }

   public Optional<Passenger> getPassengerByEmail(String email) {

      // find passenger by id from db from table passenger
      Optional<Passenger> passengerOptional = passengerRepository.findByEmail(email);
      // if no airport was found
      if (!passengerOptional.isPresent()) {
         log.warn("Passenger for {} email was not found", email);
         return Optional.empty();
      }

      // take airport object
      Passenger passenger = passengerOptional.get();

      long id = passenger.getId();
      String firstName = passenger.getFirstName();
      String lastName = passenger.getLastName();
      String username = passenger.getUsername();
      byte[] passwordHashCode = passenger.getPasswordHashCode();

      return Optional.of(new Passenger(id, firstName, lastName, email, username, passwordHashCode));
   }

}
