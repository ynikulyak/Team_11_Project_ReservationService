package cst438.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL generated value
   private Long id;
   @Column(name = "rental_car")
   private String rentalCar;
   private String shuttle;
   private String hotel;
   @Column(name = "seat_pref")
   private String seatPref;
   @Column(name = "flight_id", updatable = false)
   private long flightId;
   @Column(name = "passenger_id", updatable = false)
   private long passengerId;

   public Reservation() {
      this(null, 0, 0, "no", "no", "no", "no");
   }

   public Reservation(Long id, long passengerId, long flightId, String rentalCar, String shuttle, String hotel,
         String seatPref) {
      super();
      this.id = id;
      this.rentalCar = rentalCar;
      this.shuttle = shuttle;
      this.hotel = hotel;
      this.seatPref = seatPref;
      this.flightId = flightId;
      this.passengerId = passengerId;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public Long getFlightId() {
      return flightId;
   }

   public void setFlightId(long flightId) {
      this.flightId = flightId;
   }

   public long getPassengerId() {
      return passengerId;
   }

   public void setPassengerId(long passengerId) {
      this.passengerId = passengerId;
   }
}
