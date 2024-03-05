package assessment.parkinglot.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleTypeDoesNotExist extends RuntimeException{
    public VehicleTypeDoesNotExist() {
        super("Vehicle does not exist");
    }
}
