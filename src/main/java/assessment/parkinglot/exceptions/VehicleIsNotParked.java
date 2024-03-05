package assessment.parkinglot.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleIsNotParked extends RuntimeException{
    public VehicleIsNotParked() {
        super("Vehicle is not parked");
    }
}
