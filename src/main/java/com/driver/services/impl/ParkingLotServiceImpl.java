package com.driver.services.impl;

import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import com.driver.model.SpotType;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setName(name);
        parkingLot.setAdress(address);
        parkingLotRepository1.save(parkingLot);
        return parkingLot;

    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
    ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
    Spot spot = new Spot();
    if(numberOfWheels<=2){
        spot.setSpotType(SpotType.TWO_WHEELER);
        spot.setPricePerHour(pricePerHour);
    }
    else if(numberOfWheels>2 && numberOfWheels<=4){
        spot.setSpotType(SpotType.FOUR_WHEELER);
        spot.setPricePerHour(pricePerHour);
    }
    else if(numberOfWheels>4){
        spot.setSpotType(SpotType.OTHERS);
        spot.setPricePerHour(pricePerHour);
    }
    spot.setOccupied(false);
    spot.setParkingLot(parkingLot);
    List<Spot>spotList=parkingLot.getSpotList();
    spotList.add(spot);
    parkingLot.setSpotList(spotList);
    spotRepository1.save(spot);
    parkingLotRepository1.save(parkingLot);
    return spot;

    }

    @Override
    public void deleteSpot(int spotId){
        Spot spot=spotRepository1.findById(spotId).get();
        if(spot==null){
            try {
                throw new Exception("Spot is Not Present");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else{
            spotRepository1.deleteById(spotId);
        }

    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {
        Spot spot = spotRepository1.findById(spotId).get();

        ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId).get();

        spot.setParkingLot(parkingLot);
        spot.setPricePerHour(pricePerHour);
        spotRepository1.save(spot);
        return spot;
    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
        parkingLotRepository1.deleteById(parkingLotId);
    }
}
