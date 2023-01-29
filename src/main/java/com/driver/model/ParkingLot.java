package com.driver.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Parking_lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public ParkingLot() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Spot> getSpotList() {
        return SpotList;
    }

    public void setSpotList(List<Spot> spotList) {
        SpotList = spotList;
    }

    @OneToMany(mappedBy = "parkingLot",cascade = CascadeType.ALL)
    private  List<Spot> SpotList;

}