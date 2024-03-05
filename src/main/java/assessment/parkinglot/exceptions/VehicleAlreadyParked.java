package assessment.parkinglot.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VehicleAlreadyParked extends RuntimeException{
    public VehicleAlreadyParked() {
        super("Vehicle already parked");
    }
}
