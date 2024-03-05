package assessment.parkinglot.dto;

import java.util.Map;
import java.util.Optional;

public class AmountSpaceLeftDTO {
    private Map<String, Integer> amountSpacesLeft;
    private int totalSpaceLeft;

    public AmountSpaceLeftDTO(Map<String, Integer> amountSpacesLeft) {
        this.amountSpacesLeft = amountSpacesLeft;
        totalSpaceLeft = amountSpacesLeft.entrySet().stream().mapToInt(entry -> Optional.ofNullable(entry.getValue()).orElse(0)).sum();
    }

    public Map<String, Integer> getAmountSpacesLeft() {
        return amountSpacesLeft;
    }

    public int getTotalSpaceLeft() {
        return totalSpaceLeft;
    }
}
