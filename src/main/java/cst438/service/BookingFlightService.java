package cst438.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cst438.domain.Flight;

@Service
public class BookingFlightService {

   private static final Logger log = LoggerFactory.getLogger(BookingFlightService.class);
   private RestTemplate restTemplate;
   private String flightByIdUrl;

   public BookingFlightService(@Value("${cfis.baseurl}") String baseUrl) {
      this.restTemplate = new RestTemplate();
      this.flightByIdUrl = baseUrl + "/api/flight/v1/id/";
   }
   
   public Flight getFlightById(long id) {
      String url = flightByIdUrl + id;
      log.info("Fetching JSON from " + url);
      ResponseEntity<Flight> response = restTemplate.getForEntity(url, Flight.class);
      log.info("Status code from CFIS server, flight:" + id + " :" + response.getStatusCodeValue());
      return response.getBody();
   }
}
