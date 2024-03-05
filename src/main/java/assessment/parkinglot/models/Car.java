package assessment.parkinglot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Car")
public class Car extends Vehicle{
    
    public Car(String plateNumber, String type) {
        super(plateNumber, "CAR");
    }

    @Override
    public List<ParkingSpot> getParkingSpotsWhereCanPark(List<ParkingSpot> freeSpots) {
        List<ParkingSpot> parkingSpotsCompatible = freeSpots.stream()
            .filter(freeSpot -> freeSpot.getVehicleParked() == null && (freeSpot.getType().equals(ParkingSpotType.REGULAR_SPOT) || freeSpot.getType().equals(ParkingSpotType.COMPACT_CAR)))
            .toList();
        
        return (parkingSpotsCompatible.size() > 0) ? parkingSpotsCompatible.subList(0, 1) : null;
    }
}
