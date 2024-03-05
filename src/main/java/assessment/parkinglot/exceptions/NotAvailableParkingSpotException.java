package assessment.parkinglot.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotAvailableParkingSpotException extends RuntimeException{

    public NotAvailableParkingSpotException() {
        super("It is not possible to park specified vehicle");
    }

}
