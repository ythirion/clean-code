import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Exercise1 {

    private final LocalDate expirationDate;
    private final Boolean approvedForConsumption;
    private final Integer inspectorId;

    public boolean isEdible() {
        if (this.expirationDate.isAfter(LocalDate.now()) &&
                this.approvedForConsumption == true &&
                this.inspectorId != null) {
            return true;
        } else {
            return false;
        }
    }
}
