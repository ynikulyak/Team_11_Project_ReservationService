package cst438.Controller;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import cst438.domain.Passenger;
import cst438.service.PassengerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class PassengerRestControllerTest {
	
	@MockBean
	private PassengerService passengerService;
	
	@Autowired
	private MockMvc mvc;
	
	private JacksonTester<Passenger> json;

	private JacksonTester<List<Passenger>> listJson;
	
	@BeforeEach
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}
	@Test
	public void getPassengerByEmail() throws Exception{
		Passenger passenger = new Passenger((long) 1, "Rei", "Slogan", "na@gmail.com", "jellybean", null);
		given(passengerService.getPassengerByEmail("na@gmail.com")).willReturn(Optional.of(passenger));
		
		//When
		MockHttpServletResponse response = mvc.perform(get("/api/aiport/v1//email/na@gmail.com").contentType(MediaType.APPLICATION_JSON).content(json.write(passenger).getJson()))
	            .andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(json.write(passenger).getJson());
	}

	@Test
	public void getPassengerEmailNotFound() throws Exception{
		//get passenger email if is not there
		given(passengerService.getPassengerByEmail("na@gmail.com")).willReturn(Optional.empty());
		
		ResultActions response = mvc.perform(get("/api/passenger/v1/email/na@gmail.com"));
		
		assertThat(response.andReturn().getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void getPassengerById() throws Exception{
		Passenger passenger = new Passenger((long) 1, "Rei", "Slogan", "na@gmail.com", "jellybean", null);
		given(passengerService.getPassengerById(1)).willReturn(Optional.of(passenger));
		
		//When
		MockHttpServletResponse response = mvc.perform(get("/api/passenger/v1/1").contentType(MediaType.APPLICATION_JSON).content(json.write(passenger).getJson()))
	            .andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(json.write(passenger).getJson());
	}
	
	@Test
	public void getPassengerIdNotFound() throws Exception{
		//get passenger email if is not there
		given(passengerService.getPassengerById(1)).willReturn(Optional.empty());
		
		ResultActions response = mvc.perform(get("/api/passenger/v1/1"));
		
		assertThat(response.andReturn().getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}
}