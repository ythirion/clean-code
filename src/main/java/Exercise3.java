import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class Exercise3 {

    @AllArgsConstructor
    public class DiscountCalculator {
        private final LoyaltyDiscountCalculator loyaltyDiscountCalculator;
        private final CustomerDiscountCalculator customerDiscountCalculator;

        public double calculate(double price,
                                CustomerStatus customerStatus,
                                int yearsSinceAccountCreation) {
            double discountForCustomerStatus = customerDiscountCalculator.calculateDiscount(customerStatus);
            double discountForLoyalty = loyaltyDiscountCalculator.calculateDiscount(yearsSinceAccountCreation);

            double priceAfterDiscount = (price - (discountForCustomerStatus * price));
            return priceAfterDiscount - (discountForLoyalty * priceAfterDiscount);
        }
    }

    public class LoyaltyDiscountCalculator {
        public static final int MAXIMUM_DISCOUNT_FOR_LOYALTY = 5;

        private double calculateDiscount(int yearsSinceAccountCreation) {
            return (yearsSinceAccountCreation > 5) ? MAXIMUM_DISCOUNT_FOR_LOYALTY / 100 : yearsSinceAccountCreation / 100;
        }
    }

    public class CustomerDiscountCalculator {
        private static final double DISCOUNT_FOR_SIMPLE_CUSTOMERS = 0.1;
        private static final double DISCOUNT_FOR_VALUABLE_CUSTOMERS = 0.3;
        private static final double DISCOUNT_FOR_MOST_VALUABLE_CUSTOMERS = 0.5;

        private final HashMap<CustomerStatus, Double> discountsForCustomer = new HashMap<CustomerStatus, Double>() {{
            put(CustomerStatus.NOT_REGISTERED, 0.0);
            put(CustomerStatus.SIMPLE, DISCOUNT_FOR_SIMPLE_CUSTOMERS);
            put(CustomerStatus.VALUABLE, DISCOUNT_FOR_VALUABLE_CUSTOMERS);
            put(CustomerStatus.MOST_VALUABLE, DISCOUNT_FOR_MOST_VALUABLE_CUSTOMERS);
        }};

        private double calculateDiscount(CustomerStatus customerStatus) {
            if (!discountsForCustomer.containsKey(customerStatus))
                throw new NoSuchElementException();
            return discountsForCustomer.get(customerStatus);
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