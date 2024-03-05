package assessment.parkinglot.models;

public class GroupedTypeAndCountParkingSpotQuery {

    private int count;
    private ParkingSpotType type; 

    public GroupedTypeAndCountParkingSpotQuery() {
    }

    public int getCount() {
        return count;
    }

    public ParkingSpotType getType() {
        return type;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return count + " " + type;
    }
}
