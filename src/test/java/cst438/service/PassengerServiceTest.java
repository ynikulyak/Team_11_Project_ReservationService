package cst438.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cst438.domain.Passenger;
import cst438.domain.PassengerRepository;

import org.junit.jupiter.api.Test;

@SpringBootTest
class passengerServiceTest {
	
	@MockBean
	private PassengerRepository passengerRepository;
	
	@Autowired
	private PassengerService passengerService;

	@Test
	public void testPassengerInfo() {
		
		Passenger passenger = new Passenger((long) 1, "Rei", "John", "rj@gmail.com", "rapabapa", null);
		
		given(passengerRepository.findById(1)).willReturn(Optional.of(passenger));
		
		Optional<Passenger> passengerInfo = passengerService.getPassengerById(1);
		
		//test restult
		//check if object found
		assertThat(passengerInfo).isPresent();
		
		Passenger realPerson = passengerInfo.get();
		
		assertThat(realPerson.getFirstName()).isEqualTo("Rei");
		assertThat(realPerson.getLastName()).isEqualTo("John");
		
	}
	
	@Test
	public void testPassengerEmail() {
		
		Passenger passenger = new Passenger((long) 1, "Rei", "John", "rj@gmail.com", "rapabapa", null);
		
		given(passengerRepository.findByEmail("rj@gmail.com")).willReturn(Optional.of(passenger));
		
		Optional<Passenger> passengerInfo = passengerService.getPassengerByEmail("rj@gmail.com");
		
		//test restult
		//check if object found
		assertThat(passengerInfo).isPresent();
		
		Passenger realPerson = passengerInfo.get();
		
		assertThat(realPerson.getFirstName()).isEqualTo("Rei");
		assertThat(realPerson.getUsername()).isEqualTo("rapabapa");
		
	}

	@Test void testPassengerNotFound() {
		given(passengerRepository.findById(10)).willReturn(Optional.empty());
		
		Optional<Passenger> passengerInfo = passengerService.getPassengerById(10);
		
		assertThat(passengerInfo).isNotPresent();
		
	}
	
	@Test void testPassengerNotFoundUserName() {
		given(passengerRepository.findByEmail("Joleen@gmail.com")).willReturn(Optional.empty());
		
		Optional<Passenger> passengerInfo = passengerService.getPassengerByEmail("Joleen@gmail.com");
		
		assertThat(passengerInfo).isNotPresent();
		
	}
	
}