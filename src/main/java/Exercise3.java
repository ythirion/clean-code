import lombok.AllArgsConstructor;
import lombok.Getter;

public class Exercise3 {

    public class DiscountManager {
        public static final int MAXIMUM_DISCOUNT_FOR_LOYALTY = 5;
        public static final double DISCOUNT_FOR_SIMPLE_CUSTOMERS = 0.1;
        public static final double DISCOUNT_FOR_VALUABLE_CUSTOMERS = 0.3;
        public static final double DISCOUNT_FOR_MOST_VALUABLE_CUSTOMERS = 0.5;

        public double calculate(double price,
                                CustomerStatus customerStatus,
                                int yearsSinceAccountCreation) {
            double priceAfterDiscount = 0;
            double discountForLoyalty = calculateDiscountForLoyalty(yearsSinceAccountCreation);

            switch (customerStatus) {
                case NOT_REGISTERED:
                    priceAfterDiscount = price;
                    break;
                case SIMPLE:
                    priceAfterDiscount = (price - (DISCOUNT_FOR_SIMPLE_CUSTOMERS * price));
                    priceAfterDiscount = priceAfterDiscount - (discountForLoyalty * priceAfterDiscount);
                    break;
                case VALUABLE:
                    priceAfterDiscount = (price - (DISCOUNT_FOR_VALUABLE_CUSTOMERS * price));
                    priceAfterDiscount = priceAfterDiscount - (discountForLoyalty * priceAfterDiscount);
                    break;
                case MOST_VALUABLE:
                    priceAfterDiscount = (price - (DISCOUNT_FOR_MOST_VALUABLE_CUSTOMERS * price));
                    priceAfterDiscount = priceAfterDiscount - (discountForLoyalty * priceAfterDiscount);
                    break;
            }
            return priceAfterDiscount;
        }

        private double calculateDiscountForLoyalty(int yearsSinceAccountCreation) {
            return (yearsSinceAccountCreation > 5) ? MAXIMUM_DISCOUNT_FOR_LOYALTY / 100 : yearsSinceAccountCreation / 100;
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