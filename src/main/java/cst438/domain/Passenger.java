package cst438.domain;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL generated value
   private Long id;
   private String firstName;
   private String lastName;
   private String email;
   private String username;
   @Column(name="user_password_hash")
   private byte[] passwordHashCode;
   
   public Passenger() {
      this(null, "", "", "", "", null);
   }
   
   public Passenger(Long id, String firstName, String lastName, String email, String username, byte[] passwordHashCode) {
      super();
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.username = username;
      this.passwordHashCode = passwordHashCode;
   }


   public Long getId() {
      return id;
   }


   public void setId(Long id) {
      this.id = id;
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


   public String getUsername() {
      return username;
   }


   public void setUsername(String username) {
      this.username = username;
   }


   public byte[] getPasswordHashCode() {
      return passwordHashCode;
   }


   public void setPasswordHashCode(byte[] passwordHashCode) {
      this.passwordHashCode = passwordHashCode;
   }


   @Override
   public String toString() {
      return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
            + ", username=" + username + ", passwordHashCode=" + Arrays.toString(passwordHashCode) + "]";
   }


   @Override
   public int hashCode() {
      int prime = 31;
      int result = 1;
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
      result = prime * result + (id == null ? 0 : id.intValue());
      result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
      result = prime * result + Arrays.hashCode(passwordHashCode);
      result = prime * result + ((username == null) ? 0 : username.hashCode());
      return result;
   }


   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Passenger other = (Passenger) obj;
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
      if (id != other.id)
         return false;
      if (lastName == null) {
         if (other.lastName != null)
            return false;
      } else if (!lastName.equals(other.lastName))
         return false;
      if (!Arrays.equals(passwordHashCode, other.passwordHashCode))
         return false;
      if (username == null) {
         if (other.username != null)
            return false;
      } else if (!username.equals(other.username))
         return false;
      return true;
   }
   


}
