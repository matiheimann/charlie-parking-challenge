package assessment.parkinglot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Car.class, name = "Car"),
    @JsonSubTypes.Type(value = Van.class, name = "Van"),
    @JsonSubTypes.Type(value = Motorcycle.class, name = "Motorcycle")
})
public abstract class Vehicle {
    
    private String plateNumber;
    private String type;

    public Vehicle(String plateNumber, String type) {
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public abstract List<ParkingSpot> getParkingSpotsWhereCanPark(List<ParkingSpot> freeSpots);

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getType() {
        return type;
    }
}
