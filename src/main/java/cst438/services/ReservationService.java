package cst438.services;

import javax.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cst438.domain.Reservation;
import cst438.domain.ReservationRepository;

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
	
	public Reservation searchReservation(int idReservation) {
		log.info("Reservation retrieve: " + idReservation);
		Reservation r = reservationRepository.findByidReservation(idReservation);
		if(r != null) {
			log.info("Reservation retrieved): " +r.toString());
			return r;
		} else {
			log.info("reservation retrieve failed. Not Found. : " +idReservation);
			return null;
		}
	}
	
	public boolean deleteReservation(int idReservation) {
		Reservation r = reservationRepository.findByidReservation(idReservation);
		if (r != null) {
			reservationRepository.delete(r);
			log.info("Reservation delete: " + idReservation);
			return true;
		} else {
			log.info("reservation retrieve failed. Not Found. : " +idReservation);
			return false;
		}
	}
}