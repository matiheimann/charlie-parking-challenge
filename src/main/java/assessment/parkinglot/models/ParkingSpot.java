package assessment.parkinglot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private ParkingSpotType type;
    private String vehicleParked;

    public ParkingSpot() {
    }

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
        this.vehicleParked = null;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public String getVehicleParked() {
        return vehicleParked;
    }

    public void setVehicleParked(String vehicleParked) {
        this.vehicleParked = vehicleParked;
    }
} 