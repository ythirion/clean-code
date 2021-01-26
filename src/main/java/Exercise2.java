import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {
    public String toArrivalTable(List<LocalDate> arrivalTimes) {
        return arrivalTimes.stream()
                .map(flightArrival -> flightArrival.isAfter(LocalDate.now()) ? flightArrival.toString() : "Delayed")
                .collect(Collectors.joining("\n"));
    }
}