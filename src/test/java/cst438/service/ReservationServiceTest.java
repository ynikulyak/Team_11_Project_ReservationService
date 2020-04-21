package cst438.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cst438.domain.Reservation;
import cst438.domain.ReservationInfo;
import cst438.domain.ReservationRepository;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class ReservationServiceTest {
	
	@MockBean
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	
	@Test
	public void testReservationInfo() throws Exception{
		
		Reservation reservation = new Reservation((long) 1, 1, "John", "Ben", "jb@gmail.com", "P2232", "no", null, null, null);
		
		given(reservationRepository.findById(1)).willReturn(Optional.of(reservation));
		
		Optional<ReservationInfo> reservationInfo = reservationService.getReservationInfoById(1);
		
		//test restult
		//check if object found
		assertThat(reservationInfo).isPresent();
		
		ReservationInfo realReservationInfo = reservationInfo.get();
		
		assertThat(realReservationInfo.getFirstName()).isEqualTo("Rei");
		assertThat(realReservationInfo.getLastName()).isEqualTo("John");
	}
	
	@Test
	public void testNonReservationInfo() throws Exception {
		given(reservationRepository.findById(45)).willReturn(Optional.empty());
		
		Optional<ReservationInfo> reservationInfo = reservationService.getReservationInfoById(45);
		
		assertThat(reservationInfo).isNotPresent();
	}

	@Test
	public void deleteReservationTest() throws Exception {
		//given data
		Reservation testReservation = new Reservation(
				(long) 2, 2, "Zedn", "unad", "zu@gmail.com", "p3432", null, null, null, null);
		//entry mock into data
		given(reservationRepository.findById((long) 2)).willReturn(Optional.of(testReservation));
		boolean result = reservationService.deleteReservation((long) 2);
		assertThat(result).isTrue();
		verify(reservationRepository).delete(testReservation);
	}
	
	@Test
	public void deleteReservationFalseTest() throws Exception {
		//given data
		Reservation testReservation = new Reservation(
				(long) 2, 2, "Zedn", "unad", "zu@gmail.com", "p3432", null, null, null, null);
		//entry mock into data
		given(reservationRepository.findById((long) 3)).willReturn(Optional.of(testReservation));
		boolean result = reservationService.deleteReservation((long) 2);
		assertThat(result).isFalse();
		verify(reservationRepository).delete(testReservation);
	}

	@Test
	public void createReservationTest() throws Exception {
		Reservation entry = new Reservation();
			entry.setFlightId(1);
			entry.setFirstName("Larry");
			entry.setLastName("Johnson");
			
		Reservation indb = 
				new Reservation((long) 1, 1, "Larry", "Johnson", "lj@gmail.com", "p33243", null, null, null, "No");
		
		Reservation outdb = 
				new Reservation((long) 3, 1, "Larry", "Johnson", "lj@gmail.com", "p33243", null, null, null, "No");
		
		Reservation expected = 
				new Reservation((long) 3, 1, "Larry", "Johnson", "lj@gmail.com", "p33243", null, null, null, "No");
		
		given(reservationRepository.save(indb)).willReturn(outdb);
		
		Reservation actual = reservationService.create(entry);
		assertThat(actual).isEqualTo(expected);
		assertThat(actual.getFirstName()).isEqualTo("Larry");
	}
}
