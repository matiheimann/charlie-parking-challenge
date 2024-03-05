package assessment.parkinglot.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import assessment.parkinglot.models.ParkingSpot;
import assessment.parkinglot.models.ParkingSpotType;
import assessment.parkinglot.repostiories.ParkingSpotRepository;

@Component
public class ParkingLotInitializer implements CommandLineRunner {
    private final ParkingSpotRepository spotRepository;

    @Autowired
    public ParkingLotInitializer(ParkingSpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if the spots are already initialized
        if (spotRepository.count() == 0) {
            for (int i = 0; i < 5; i++) {
                ParkingSpot spot = new ParkingSpot(ParkingSpotType.MOTORCYCLE);
                spotRepository.save(spot);
            }
            for (int i = 0; i < 8; i++) {
                ParkingSpot spot = new ParkingSpot(ParkingSpotType.COMPACT_CAR);
                spotRepository.save(spot);
            }
            for (int i = 0; i < 12; i++) {
                ParkingSpot spot = new ParkingSpot(ParkingSpotType.REGULAR_SPOT);
                spotRepository.save(spot);
            }
        }
    }
}