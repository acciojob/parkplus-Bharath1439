package com.driver.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String PhoneNumber;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<Reservation> getReservationList() {
        return ReservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        ReservationList = reservationList;
    }

    private String Password;

    public User(String name, String phoneNumber, String password) {
        this.name = name;
        PhoneNumber = phoneNumber;
        Password = password;
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Reservation> ReservationList;


}
