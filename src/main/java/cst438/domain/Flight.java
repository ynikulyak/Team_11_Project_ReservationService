package cst438.domain;

public class Flight {

   public Long id;
   public String flightCode;
   public String fromAirportCode;
   public String toAirportCode;
   public String departure;
   public String arrival;
   public String airportTitleFrom;
   public String airportLocationFrom;
   public String airportTitleTo;
   public String airportLocationTo;
   
   
   public Flight(Long id, String flightCode, String fromAirportCode, String toAirportCode, String departure,
         String arrival, String airportTitleFrom, String airportLocationFrom, String airportTitleTo,
         String airportLocationTo) {
      super();
      this.id = id;
      this.flightCode = flightCode;
      this.fromAirportCode = fromAirportCode;
      this.toAirportCode = toAirportCode;
      this.departure = departure;
      this.arrival = arrival;
      this.airportTitleFrom = airportTitleFrom;
      this.airportLocationFrom = airportLocationFrom;
      this.airportTitleTo = airportTitleTo;
      this.airportLocationTo = airportLocationTo;
   }
}
