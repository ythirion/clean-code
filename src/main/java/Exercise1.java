import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Exercise1 {

    private final LocalDate expirationDate;
    private final Boolean approvedForConsumption;
    private final Integer inspectorId;

    public boolean isEdible() {
        return isFresh() &&
                hasBeenApprovedForConsumption() &&
                hasBeenInspected();
    }

    private Boolean hasBeenApprovedForConsumption() {
        return this.approvedForConsumption;
    }

    private boolean isFresh() {
        return this.expirationDate.isAfter(LocalDate.now());
    }

    private boolean hasBeenInspected() {
        return this.inspectorId != null;
    }
}