package assessment.parkinglot.services;

import assessment.parkinglot.dto.AllSpacesTakenDTO;
import assessment.parkinglot.dto.AmountSpaceLeftDTO;
import assessment.parkinglot.models.Vehicle;

public interface ParkingLotService {
    public void parkVehicle(Vehicle vehicle);
    public void vehicleLeftParking(Vehicle vehicle);
    public AmountSpaceLeftDTO getAmountOfSpacesLeft();
    public AllSpacesTakenDTO areAllSpacesTaken(String vehicleType); 
}
