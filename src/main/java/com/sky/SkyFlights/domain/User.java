package com.sky.SkyFlights.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "email", "username" }))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int userID;

	@Column(nullable = false)
	public String firstName;

	@Column(nullable = false)
	public String lastName;

	@Column(nullable = false)
	public String username;

	@Column(nullable = false, unique = true)
	public String email;

	@Column(nullable = false)
	public String password;
//    @OneToMany(mappedBy = "user")
//    @JsonManagedReference
//    public List<Booking> booking;

	public User(int userID, String firstName, String lastName, String username, String email, String password) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
//        this.booking = booking;
	}

	public User() {
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//    public List<Booking> getBooking() {
//        return booking;
//    }
//
//    public void setBooking(List<Booking> booking) {
//        this.booking = booking;
//    }

	@Override
	public String toString() {
		return "User{" + "userID=" + userID + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", userName='" + username + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' +
//                ", booking=" + booking +
				'}';
	}
}
