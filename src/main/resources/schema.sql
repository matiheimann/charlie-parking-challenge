CREATE TABLE parking_spot (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(255) NOT NULL,
    vehicle_parked VARCHAR(255)
);