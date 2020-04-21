package cst438.Controller;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import cst438.domain.Reservation;
import cst438.domain.ReservationInfo;
import cst438.service.ReservationService;

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


public class ReservationRestControllerTest {
	
	@MockBean
	private ReservationService reservationService;
	
	@Autowired
	private MockMvc mvc;
	
	private JacksonTester<Reservation> json;

	private JacksonTester<List<Reservation>> listJson;
	
	@BeforeEach
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void getReservation() throws Exception{
		Reservation reservation = new Reservation((long) 1, 1, "Rei", "Slogan", "na@gmail.com", "jellybean", null, null, null, null);
		given(reservationService.findReservation((long) 1)).willReturn(reservation);
		
		//When
		MockHttpServletResponse response = mvc.perform(get("/api/aiport/v1//1").contentType(MediaType.APPLICATION_JSON).content(json.write(reservation).getJson()))
	            .andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(json.write(reservation).getJson());
	}
	
	@Test
	public void getReservationNotFound() throws Exception{

		given(reservationService.getReservationInfoById((long) 3)).willReturn(Optional.empty());
		
		ResultActions response = mvc.perform(get("/api/passenger/v1/1"));
		
		assertThat(response.andReturn().getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}
}
