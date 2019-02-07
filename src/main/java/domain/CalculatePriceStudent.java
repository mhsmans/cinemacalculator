package domain;

import java.util.ArrayList;

public class CalculatePriceStudent implements CalculatePriceBehavior {
    public double calculatePrice(ArrayList<MovieTicket> tickets) {

        double totalPrice = 0;

        for (int i = 0; i < tickets.size(); i++) {
            // Check if index is even, if not add price
            if (i % 2 != 0 || i == 0) {
                // Check if premium ticket
                if (tickets.get(i).isPremiumTicket()) {
                    totalPrice = totalPrice + tickets.get(i).getPrice() + 2;
                } else {
                    totalPrice += tickets.get(i).getPrice();
                }
            }
        }
        System.out.println("Total student price is " + totalPrice);
        return totalPrice;
    }
}
