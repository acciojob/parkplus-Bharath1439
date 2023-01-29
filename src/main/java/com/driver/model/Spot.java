package com.driver.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="spot")
public class Spot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int PricePerHour;

    public Spot() {
    }

    public Spot(int pricePerHour, SpotType spotType, Boolean occupied) {
        PricePerHour = pricePerHour;
        this.spotType = spotType;
        this.occupied = occupied;
    }

    @Enumerated(value = EnumType.STRING)
    private SpotType spotType;

    private Boolean occupied;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPricePerHour() {
        return PricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        PricePerHour = pricePerHour;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<Reservation> getReservationList() {
        return ReservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        ReservationList = reservationList;
    }

    @ManyToOne
    @JoinColumn
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "spot",cascade = CascadeType.ALL)
    private List<Reservation> ReservationList;
}
