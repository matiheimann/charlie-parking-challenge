package assessment.parkinglot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Motorcycle")
public class Motorcycle extends Vehicle {

    public Motorcycle(String plateNumber, String type) {
        super(plateNumber, "MOTORCYCLE");
    }

    @Override
    public List<ParkingSpot> getParkingSpotsWhereCanPark(List<ParkingSpot> freeSpots) {
        List<ParkingSpot> parkingSpotsCompatible = freeSpots.stream().filter(freeSpot -> freeSpot.getVehicleParked() == null && freeSpot.getType().equals(ParkingSpotType.MOTORCYCLE)).toList();
        return (parkingSpotsCompatible.size() > 0) ? parkingSpotsCompatible.subList(0, 1) : null;
    }
    
}
