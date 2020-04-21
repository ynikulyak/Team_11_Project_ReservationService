package cst438.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cst438.domain.Reservation;
import cst438.domain.ReservationRepository;
import cst438.service.ReservationService;

@Controller
public class ReservationController {
	
	private ReservationService reservationService;
	
	private ReservationRepository reservationRepository;
	
	private static final Logger log = LoggerFactory.getLogger(ReservationService.class);

	@GetMapping("/findReservation")
   public String getReservation(@RequestParam("flightId") Long flightId, Model model) {
		log.info("Show reservation search" +flightId);
		Optional<Reservation> reservation = reservationRepository.findById(flightId);
		if(!reservation.isPresent()) {
			log.info("Flight Not found" +flightId);
			}
		model.addAttribute("reservation", reservation.get());
		return "reservation/findReservation";
		}

	@GetMapping("/delete")
	public String delete(@RequestParam("flightId") Long flightId){
			reservationService.deleteReservation(flightId);
			
			return "delete";
	}

}

