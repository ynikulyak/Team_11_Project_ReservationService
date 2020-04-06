package cst438.service;

import javax.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cst438.domain.Reservation;

@Service
public class ReservationService {
	
	private static final Logger log = LoggerFactory.getLogger(ReservationService.class);

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	public ReservationService() {
	}

	public ReservationService(FlightRepository flightRepository, ReservationRepository reservationRepository) {
		this.flightRepository = flightRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public Reservation searchReservation(int Reservation) {
		log.info("Reservation retrieve: " + Reservation);
		Reservation r = reservationRepository.findByidReservation(Reservation);
		if(r != null) {
			log.info("Reservation retrieved): " +r.toString());
			return r;
		} else {
			log.info("reservation retrieve failed. Not Found. : " +Reservation);
			return null;
		}
		}
}
