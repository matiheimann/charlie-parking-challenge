package assessment.parkinglot.models;

public enum ParkingSpotType {
    MOTORCYCLE((byte) 0), COMPACT_CAR((byte) 1), REGULAR_SPOT((byte) 2);

    private final byte value;

    ParkingSpotType(byte value) {
        this.value = value;
    }

    public static ParkingSpotType valueOf(byte value) {
        for (ParkingSpotType e : values()) {
            if (e.value == value) {
                return e;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
}
