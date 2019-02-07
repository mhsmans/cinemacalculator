package domain;

import java.util.ArrayList;

public class CalculatePriceWeekend implements CalculatePriceBehavior {
    public double calculatePrice(ArrayList<MovieTicket> tickets) {

        double totalPrice = 0;

        for (int i = 0; i < tickets.size(); i++) {
            // Check if premium ticket
            if (tickets.get(i).isPremiumTicket()) {
                totalPrice = totalPrice + tickets.get(i).getPrice() + 3;
            } else {
                totalPrice += tickets.get(i).getPrice();
            }
        }
        // 6 tickets or more? 10% discount.
        if (tickets.size() >= 6) {
            totalPrice = totalPrice * 0.9;
        }
        System.out.println("Total weekend price is " + totalPrice);
        return totalPrice;
    }
}
