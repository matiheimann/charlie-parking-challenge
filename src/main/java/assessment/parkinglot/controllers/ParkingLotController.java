package assessment.parkinglot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import assessment.parkinglot.dto.AllSpacesTakenDTO;
import assessment.parkinglot.dto.AmountSpaceLeftDTO;
import assessment.parkinglot.models.Vehicle;
import assessment.parkinglot.services.ParkingLotService;

@RestController
@RequestMapping("/api")
public class ParkingLotController {

    private ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping("/park-vehicle")
    public void parkVehicle(@RequestBody Vehicle vehicle) {
        parkingLotService.parkVehicle(vehicle);
    }

    @PostMapping("/vehicle-left-parking")
    public void unParkVehicle(@RequestBody Vehicle vehicle) {
        parkingLotService.vehicleLeftParking(vehicle);
    }

    @GetMapping("/spots-available")
    public AmountSpaceLeftDTO spotsAvailable() {
        return parkingLotService.getAmountOfSpacesLeft();
    }

    @GetMapping("/all-spaces-taken")
    public AllSpacesTakenDTO areAllSpacesTaken(@RequestParam String type) {
        return parkingLotService.areAllSpacesTaken(type);
    }
}
