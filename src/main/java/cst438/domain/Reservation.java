package cst438.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

   @Id
	private int id;
   @Column(name="rental_car")
	private String rentalCar;
	private String shuttle;
	private String hotel;
	@Column(name="seat_pref")
	private String seatPref;
	@Column(name="flight_id")
	private int flightId;
	@Column(name="passenger_id")
	private int passengerId;
	
	public Reservation() {
	   this(0, 0, 0, "no", "no", "no", "no");
	}

	public Reservation(int idReservation, int passenger_idPassenger, int flight_idFlight, String rentalCar, String shuttle, String hotel, String seatPref) {
		super();
		this.id = idReservation;
		this.rentalCar = rentalCar;
		this.shuttle = shuttle;
		this.hotel = hotel;
		this.seatPref = seatPref;
		this.flightId = flight_idFlight;
		this.passengerId = passenger_idPassenger;
	}

	public int getIdReservation() {
		return id;
	}

	public void setIdReservation(int idReservation) {
		this.id = idReservation;
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

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flight_idFlight) {
		this.flightId = flight_idFlight;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passenger_idPassenger) {
		this.passengerId = passenger_idPassenger;
	}
}
