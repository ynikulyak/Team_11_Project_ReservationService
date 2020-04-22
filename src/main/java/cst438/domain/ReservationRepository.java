package cst438.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Optional<Reservation> findById(long reservationId);
	
	Optional<Reservation> findByFlightId(long flightId);
	
}