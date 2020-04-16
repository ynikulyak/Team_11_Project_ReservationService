package cst438.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

   Optional<Passenger> findById(int passengerId);
   
   Optional<Passenger> findByUsername(String username);
   
   Optional<Passenger> findByEmail(String email);
   
   Optional<Passenger> findByName(String name);
}