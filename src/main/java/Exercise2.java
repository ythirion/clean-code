import java.time.LocalDate;
import java.util.List;

public class Exercise2 {
    public String toArrivalTable(List<LocalDate> arrivalTimes) {
        StringBuilder arrivalTable = new StringBuilder();

        for (LocalDate flightArrival : arrivalTimes) {
            if (flightArrival.isAfter(LocalDate.now())) {
                arrivalTable.append(flightArrival + "\n");
            } else {
                arrivalTable.append("Delayed\n");
            }
        }
        return arrivalTable.toString();
    }
}