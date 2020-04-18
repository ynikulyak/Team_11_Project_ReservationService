package cst438.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cst438.domain.Flight;
import cst438.domain.Passenger;
import cst438.domain.PassengerRepository;
import cst438.domain.Reservation;
import cst438.domain.ReservationInfo;
import cst438.domain.ReservationRepository;

@Service
public class ReservationService {

   private static final Logger log = LoggerFactory.getLogger(ReservationService.class);

   @Autowired
   private ReservationRepository reservationRepository;

   @Autowired
   private PassengerRepository passengerRepository;

   @Autowired
   private BookingFlightService bookingFlightService;

   public Reservation create(Reservation reservation) {
      reservation.setId(null);
      if (reservation.getFlightId() <= 0L || reservation.getPassengerId() <= 0L) {
         throw new IllegalArgumentException("flightId and passengerId are required.");
      }
      log.info("Creating reservation flightId/passengerId: " + reservation.getFlightId() + "/"
            + reservation.getPassengerId() + ", seat: " + reservation.getSeatPref());
      return reservationRepository.saveAndFlush(reservation);
   }

   public Optional<ReservationInfo> getReservationInfoById(long id) {

      Optional<Reservation> reservationOptional = reservationRepository.findById(id);
      // if result is empty
      if (!reservationOptional.isPresent()) {
         log.warn("Reservation for {} id was not found", id);
         return Optional.empty();
      }

      // take reservation object from Optional
      Reservation r = reservationOptional.get();

      long passengerId = r.getPassengerId();
      long flightId = r.getFlightId();
      String rentCar = r.getRentalCar();
      String hotel = r.getHotel();
      String shuttle = r.getShuttle();
      String seatPref = r.getSeatPref();

      // find country by code from db from table country
      Optional<Passenger> passengerOptional = passengerRepository.findById((passengerId));
      // if no passenger was found
      if (!passengerOptional.isPresent()) {
         log.warn("Passenger for {} id was not found", passengerId);
         return Optional.empty();
      }

      // take country object
      Passenger passenger = passengerOptional.get();

      String firstName = passenger.getFirstName();
      String lastName = passenger.getLastName();
      String email = passenger.getEmail();

      // return flight info from external api using flight service
      Flight flightInfo = bookingFlightService.getFlightById(flightId);

      String flightCode = flightInfo.flightCode;
      String fromAirportCode = flightInfo.fromAirportCode;
      String toAirportCode = flightInfo.toAirportCode;
      String departure = flightInfo.departure;
      String arrival = flightInfo.arrival;
      String airportTitleFrom = flightInfo.airportTitleFrom;
      String airportLocationFrom = flightInfo.airportLocationFrom;
      String airportTitleTo = flightInfo.airportTitleTo;
      String airportLocationTo = flightInfo.airportLocationTo;

      return Optional.of(new ReservationInfo(r.getId(), flightId, firstName, lastName, email, rentCar, shuttle, hotel,
            seatPref, flightCode, fromAirportCode, toAirportCode, departure, arrival, airportTitleFrom,
            airportLocationFrom, airportTitleTo, airportLocationTo));
   }

}
