package assessment.parkinglot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Van")
public class Van extends Vehicle {

    public Van(String plateNumber, String type) {
        super(plateNumber, "Van");
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<ParkingSpot> getParkingSpotsWhereCanPark(List<ParkingSpot> freeSpots) {
        List<ParkingSpot> compatibleParkingSpot = freeSpots.stream().filter(freeSpot -> freeSpot.getVehicleParked() == null && freeSpot.getType().equals(ParkingSpotType.REGULAR_SPOT)).toList();
        return (compatibleParkingSpot.size() >= 3) ? compatibleParkingSpot.subList(0, 3) : null;
    }
    
}
