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
   @Column(name = "shuttle")
   private String shuttle;
   @Column(name = "hotel")
   private String hotel;
   @Column(name = "seat_pref")
   private String seatPref;
   @Column(name = "flight_id", updatable = false)
   private long flightId;
   @Column(name = "first_name")
   private String firstName;
   @Column(name = "last_name")
   private String lastName;
   @Column(name = "email")
   private String email;
   @Column(name = "passport_number")
   private String passportNumber;


   public Reservation() {
      this(null, 0, null, null, null, null, "no", "no", "no", "no");
   }

   public Reservation(Long id, long flightId, String firstName, String lastName, String email, String passportNumber, String rentalCar, String shuttle, String hotel,
         String seatPref) {
      super();
      this.id = id;
      this.rentalCar = rentalCar;
      this.shuttle = shuttle;
      this.hotel = hotel;
      this.seatPref = seatPref;
      this.flightId = flightId;
      this.passportNumber = passportNumber;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
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

   public String getPassportNumber() {
      return passportNumber;
   }

   public void setPassportNumber(String passportNumber) {
      this.passportNumber = passportNumber;
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
}
