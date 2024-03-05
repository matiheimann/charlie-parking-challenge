package assessment.parkinglot.repostiories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import assessment.parkinglot.models.ParkingSpot;
import assessment.parkinglot.models.ParkingSpotType;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

    public List<ParkingSpot> findAllByVehicleParkedIsNull();
    public List<ParkingSpot> findAllByVehicleParked(String vehicleParked);
    public List<ParkingSpot> findAllByTypeInAndVehicleParkedIsNull(List<ParkingSpotType> types);
    @Query(value = "SELECT p.type, count(p.id) FROM parking_spot p WHERE p.vehicle_parked is null GROUP BY p.type", nativeQuery = true)
    public List<Object[]> findAllFreeParkingSpotAndCountThemByType();

}
