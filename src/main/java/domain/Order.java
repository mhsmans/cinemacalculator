package domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;

    private ArrayList<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;

        tickets = new ArrayList<MovieTicket>();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public double calculatePrice() {


        double totalPrice = 0;

        // Student order
        if (this.isStudentOrder == true) {
            for (int i = 0; i < tickets.size(); i++) {
                // Check if index is even, if not add price
                if (i % 2 != 0 || i == 0) {
                    // Check if premium ticket
                    if (tickets.get(i).isPremiumTicket() == true) {
                        totalPrice = totalPrice + tickets.get(i).getPrice() + 2;
                    } else {
                        totalPrice += tickets.get(i).getPrice();
                    }
                }
            }
        }
        // Normaal order
        else {
            for (int i = 0; i < tickets.size(); i++) {
                // Check if index is even and not equals 0
                if (i % 2 == 0 && i != 0 && tickets.get(i).getDate().getDayOfWeek().toString() == "MONDAY" ||
                        i % 2 == 0 && i != 0 && tickets.get(i).getDate().getDayOfWeek().toString() == "TUESDAY" ||
                        i % 2 == 0 && i != 0 && tickets.get(i).getDate().getDayOfWeek().toString() == "WEDNESDAY" ||
                        i % 2 == 0 && i != 0 && tickets.get(i).getDate().getDayOfWeek().toString() == "THURSDAY") {
                } else {
                    // Check if premium ticket
                    if (tickets.get(i).isPremiumTicket() == true) {
                        totalPrice = totalPrice + tickets.get(i).getPrice() + 3;
                    } else {
                        totalPrice += tickets.get(i).getPrice();
                    }
                }
            }
            // Meer dan zes kaartjes? Tien procent korting op totaal.
            if (tickets.size() >= 6) {
                totalPrice = totalPrice * 0.9;
            }
        }
        System.out.println("Total price equals: " + totalPrice);
        return totalPrice;
    }

    public void export(TicketExportFormat exportFormat) {
        // Bases on the string respresentations of the tickets (toString), write
        // the ticket to a file with naming convention Order_<orderNr>.txt of
        // Order_<orderNr>.json
    }
}

