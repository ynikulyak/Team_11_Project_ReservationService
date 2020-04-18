package cst438.domain;

public class ReservationInfo {
   
   Long reservationId;
   Long flightId;
   String firstName;
   String lastName;
   String email;
   String rentalCar;
   String shuttle;
   String hotel;
   String seatPref;
   String flightCode;
   String fromAirportCode;
   String toAirportCode;
   String departure;
   String arrival;
   String airportTitleFrom;
   String airportLocationFrom;
   String airportTitleTo;
   String airportLocationTo;
   
   public ReservationInfo() {
      this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
   }

   public ReservationInfo(Long reservationId, Long flightId, String firstName, String lastName, String email,
         String rentalCar, String shuttle, String hotel, String seatPref, String flightCode, String fromAirportCode,
         String toAirportCode, String departure, String arrival, String airportTitleFrom, String airportLocationFrom,
         String airportTitleTo, String airportLocationTo) {
      super();
      this.reservationId = reservationId;
      this.flightId = flightId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.rentalCar = rentalCar;
      this.shuttle = shuttle;
      this.hotel = hotel;
      this.seatPref = seatPref;
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

   public Long getReservationId() {
      return reservationId;
   }

   public void setReservationId(Long reservationId) {
      this.reservationId = reservationId;
   }

   public long getFlightId() {
      return flightId;
   }

   public void setFlightId(Long flightId) {
      this.flightId = flightId;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getRentalCar() {
      return rentalCar;
   }

   public void setRentalCar(String rentalCar) {
      this.rentalCar = rentalCar;
   }

   public String getShuttle() {
      return shuttle;
   }

   public void setShuttle(String shuttle) {
      this.shuttle = shuttle;
   }

   public String getHotel() {
      return hotel;
   }

   public void setHotel(String hotel) {
      this.hotel = hotel;
   }

   public String getSeatPref() {
      return seatPref;
   }

   public void setSeatPref(String seatPref) {
      this.seatPref = seatPref;
   }

   public String getFlightCode() {
      return flightCode;
   }

   public void setFlightCode(String flightCode) {
      this.flightCode = flightCode;
   }

   public String getFromAirportCode() {
      return fromAirportCode;
   }

   public void setFromAirportCode(String fromAirportCode) {
      this.fromAirportCode = fromAirportCode;
   }

   public String getToAirportCode() {
      return toAirportCode;
   }

   public void setToAirportCode(String toAirportCode) {
      this.toAirportCode = toAirportCode;
   }

   public String getDeparture() {
      return departure;
   }

   public void setDeparture(String departure) {
      this.departure = departure;
   }

   public String getArrival() {
      return arrival;
   }

   public void setArrival(String arrival) {
      this.arrival = arrival;
   }

   public String getAirportTitleFrom() {
      return airportTitleFrom;
   }

   public void setAirportTitleFrom(String airportTitleFrom) {
      this.airportTitleFrom = airportTitleFrom;
   }

   public String getAirportLocationFrom() {
      return airportLocationFrom;
   }

   public void setAirportLocationFrom(String airportLocationFrom) {
      this.airportLocationFrom = airportLocationFrom;
   }

   public String getAirportTitleTo() {
      return airportTitleTo;
   }

   public void setAirportTitleTo(String airportTitleTo) {
      this.airportTitleTo = airportTitleTo;
   }

   public String getAirportLocationTo() {
      return airportLocationTo;
   }

   public void setAirportLocationTo(String airportLocationTo) {
      this.airportLocationTo = airportLocationTo;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      ReservationInfo other = (ReservationInfo) obj;
      if (airportLocationFrom == null) {
         if (other.airportLocationFrom != null)
            return false;
      } else if (!airportLocationFrom.equals(other.airportLocationFrom))
         return false;
      if (airportLocationTo == null) {
         if (other.airportLocationTo != null)
            return false;
      } else if (!airportLocationTo.equals(other.airportLocationTo))
         return false;
      if (airportTitleFrom == null) {
         if (other.airportTitleFrom != null)
            return false;
      } else if (!airportTitleFrom.equals(other.airportTitleFrom))
         return false;
      if (airportTitleTo == null) {
         if (other.airportTitleTo != null)
            return false;
      } else if (!airportTitleTo.equals(other.airportTitleTo))
         return false;
      if (arrival == null) {
         if (other.arrival != null)
            return false;
      } else if (!arrival.equals(other.arrival))
         return false;
      if (departure == null) {
         if (other.departure != null)
            return false;
      } else if (!departure.equals(other.departure))
         return false;
      if (email == null) {
         if (other.email != null)
            return false;
      } else if (!email.equals(other.email))
         return false;
      if (firstName == null) {
         if (other.firstName != null)
            return false;
      } else if (!firstName.equals(other.firstName))
         return false;
      if (flightCode == null) {
         if (other.flightCode != null)
            return false;
      } else if (!flightCode.equals(other.flightCode))
         return false;
      if (flightId != other.flightId)
         return false;
      if (fromAirportCode == null) {
         if (other.fromAirportCode != null)
            return false;
      } else if (!fromAirportCode.equals(other.fromAirportCode))
         return false;
      if (hotel == null) {
         if (other.hotel != null)
            return false;
      } else if (!hotel.equals(other.hotel))
         return false;
      if (lastName == null) {
         if (other.lastName != null)
            return false;
      } else if (!lastName.equals(other.lastName))
         return false;
      if (rentalCar == null) {
         if (other.rentalCar != null)
            return false;
      } else if (!rentalCar.equals(other.rentalCar))
         return false;
      if (reservationId != other.reservationId)
         return false;
      if (seatPref == null) {
         if (other.seatPref != null)
            return false;
      } else if (!seatPref.equals(other.seatPref))
         return false;
      if (shuttle == null) {
         if (other.shuttle != null)
            return false;
      } else if (!shuttle.equals(other.shuttle))
         return false;
      if (toAirportCode == null) {
         if (other.toAirportCode != null)
            return false;
      } else if (!toAirportCode.equals(other.toAirportCode))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "ReservationInfo [reservationId=" + reservationId + ", flightId=" + flightId + ", firstName=" + firstName
            + ", lastName=" + lastName + ", email=" + email + ", rentalCar=" + rentalCar + ", shuttle=" + shuttle
            + ", hotel=" + hotel + ", seatPref=" + seatPref + ", flightCode=" + flightCode + ", fromAirportCode="
            + fromAirportCode + ", toAirportCode=" + toAirportCode + ", departure=" + departure + ", arrival=" + arrival
            + ", airportTitleFrom=" + airportTitleFrom + ", airportLocationFrom=" + airportLocationFrom
            + ", airportTitleTo=" + airportTitleTo + ", airportLocationTo=" + airportLocationTo + "]";
   }
   
   
}
