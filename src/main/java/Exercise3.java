import lombok.AllArgsConstructor;
import lombok.Getter;

public class Exercise3 {

    public class DiscountManager {
        public double calculate(double amount, CustomerStatus customerStatus, int years) {
            double priceAfterDiscount = 0;
            double disc = (years > 5) ? (double) 5 / 100 : (double) years / 100;

            if (customerStatus == CustomerStatus.NOT_REGISTERED) {
                priceAfterDiscount = amount;
            } else if (customerStatus == CustomerStatus.SIMPLE) {
                priceAfterDiscount = (amount - (0.1 * amount)) - disc * (amount - (0.1 * amount));
            } else if (customerStatus == CustomerStatus.VALUABLE) {
                priceAfterDiscount = (0.7 * amount) - disc * (0.7 * amount);
            } else if (customerStatus == CustomerStatus.MOST_VALUABLE) {
                priceAfterDiscount = (amount - (0.5 * amount)) - disc * (amount - (0.5 * amount));
            }
            return priceAfterDiscount;
        }
    }

    @AllArgsConstructor
    public enum CustomerStatus {
        NOT_REGISTERED(1), // all these enums give error, for no constructor
        SIMPLE(2),
        VALUABLE(3),
        MOST_VALUABLE(4);

        @Getter
        private final int value;
    }
}