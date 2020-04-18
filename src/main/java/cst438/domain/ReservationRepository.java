package cst438.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	Optional<Reservation> findById(long reservationId);
	
	Optional<Reservation> findByFlightId(long flightId);
	
	@Query("select r from Reservation r where r.passengerId = ?1")
	List<Reservation> findByPassengerId(long passengerId);
}