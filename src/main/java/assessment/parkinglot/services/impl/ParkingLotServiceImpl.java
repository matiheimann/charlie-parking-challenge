package assessment.parkinglot.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assessment.parkinglot.dto.AllSpacesTakenDTO;
import assessment.parkinglot.dto.AmountSpaceLeftDTO;
import assessment.parkinglot.exceptions.NotAvailableParkingSpotException;
import assessment.parkinglot.exceptions.VehicleAlreadyParked;
import assessment.parkinglot.exceptions.VehicleIsNotParked;
import assessment.parkinglot.exceptions.VehicleTypeDoesNotExist;
import assessment.parkinglot.models.GroupedTypeAndCountParkingSpotQuery;
import assessment.parkinglot.models.ParkingSpot;
import assessment.parkinglot.models.ParkingSpotType;
import assessment.parkinglot.models.Vehicle;
import assessment.parkinglot.repostiories.ParkingSpotRepository;
import assessment.parkinglot.services.ParkingLotService;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public ParkingLotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {

        boolean isVehicleAlreadyTaken = this.parkingSpotRepository.findAllByVehicleParked(vehicle.getPlateNumber()).size() > 0; 
        if(isVehicleAlreadyTaken) {
            throw new VehicleAlreadyParked();
        }

        List<ParkingSpot> freeParkingSpots = this.parkingSpotRepository.findAllByVehicleParkedIsNull();
        freeParkingSpots = vehicle.getParkingSpotsWhereCanPark(freeParkingSpots);

        if(freeParkingSpots == null) {
            throw new NotAvailableParkingSpotException();
        }

        freeParkingSpots.forEach(freeParkingSpot -> freeParkingSpot.setVehicleParked(vehicle.getPlateNumber()));
        this.parkingSpotRepository.saveAll(freeParkingSpots);
    }

    @Override
    public void vehicleLeftParking(Vehicle vehicle) {
        List<ParkingSpot> parkingSpotsTakenByVehicle = this.parkingSpotRepository.findAllByVehicleParked(vehicle.getPlateNumber());

        if(parkingSpotsTakenByVehicle.size() == 0) {
            throw new VehicleIsNotParked();
        }

        parkingSpotsTakenByVehicle.forEach(parkingSpot -> parkingSpot.setVehicleParked(null));
        this.parkingSpotRepository.saveAll(parkingSpotsTakenByVehicle);
    }

    @Override
    public AmountSpaceLeftDTO getAmountOfSpacesLeft() {
        List<Object[]> groupedAndCountFreeSpaces = this.parkingSpotRepository.findAllFreeParkingSpotAndCountThemByType();

        Map<String, Integer> remainingSpotsByType = new HashMap<>();
        remainingSpotsByType.put("motorcycle", 0);
        remainingSpotsByType.put("compactCar", 0);
        remainingSpotsByType.put("regularSpot", 0);

        groupedAndCountFreeSpaces.forEach(spot -> {
            switch (ParkingSpotType.valueOf((Byte)spot[0])) {
                case COMPACT_CAR:
                    remainingSpotsByType.put("compactCar", ((Long)spot[1]).intValue());
                    break;
                case MOTORCYCLE:
                    remainingSpotsByType.put("motorcycle", ((Long)spot[1]).intValue());
                    break;
                case REGULAR_SPOT:
                remainingSpotsByType.put("regularSpot", ((Long)spot[1]).intValue());
                    break;
                default:
                    break;
    
            }
        });

        return new AmountSpaceLeftDTO(remainingSpotsByType);
    }

    @Override
    public AllSpacesTakenDTO areAllSpacesTaken(String vehicleType) {
        List<ParkingSpot> parkingSpots;
        switch (vehicleType.toLowerCase()) {
            case "motorcycle": 
                parkingSpots = this.parkingSpotRepository.findAllByTypeInAndVehicleParkedIsNull(List.of(ParkingSpotType.MOTORCYCLE));
                return new AllSpacesTakenDTO(parkingSpots.size() > 0);
            case "car": 
                parkingSpots = this.parkingSpotRepository.findAllByTypeInAndVehicleParkedIsNull(List.of(ParkingSpotType.COMPACT_CAR, ParkingSpotType.REGULAR_SPOT));
                return new AllSpacesTakenDTO(parkingSpots.size() > 0);
            case "van":
                parkingSpots = this.parkingSpotRepository.findAllByTypeInAndVehicleParkedIsNull(List.of(ParkingSpotType.REGULAR_SPOT));
                return new AllSpacesTakenDTO(parkingSpots.size() > 3);
            default:
                throw new VehicleTypeDoesNotExist();
        }
    }
    
}
