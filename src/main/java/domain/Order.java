package domain;

import java.io.*;
import java.util.*;

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

    // Cyclomatic complexity (20?)
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
        // Normal order
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
            // 6 tickets or more? 10% discount.
            if (tickets.size() >= 6) {
                totalPrice = totalPrice * 0.9;
            }
        }
        System.out.println("Total price equals: " + totalPrice);
        return totalPrice;
    }

    // Updated function for cyclomatic complexity (16?)
    public double calculatePriceTwo() {
        double totalPrice = 0;
        boolean weekend = false;

        // Check if tickets are weekend tickets
        if (tickets.get(0).getDate().getDayOfWeek().toString() == "FRIDAY" ||
                tickets.get(0).getDate().getDayOfWeek().toString() == "SATURDAY" ||
                tickets.get(0).getDate().getDayOfWeek().toString() == "SUNDAY") {
            weekend = true;
        }

        // Student order
        if (isStudentOrder) {
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
        }
        // Normal order weekend
        else if (!weekend) {
            for (int i = 0; i < tickets.size(); i++) {
                if (i % 2 != 0 || i == 0) {
                    // Check if premium ticket
                    if (tickets.get(i).isPremiumTicket()) {
                        totalPrice = totalPrice + tickets.get(i).getPrice() + 3;
                    } else {
                        totalPrice += tickets.get(i).getPrice();
                    }
                }
            }
            // 6 tickets or more? 10% discount.
            if (tickets.size() >= 6) {
                totalPrice = totalPrice * 0.9;
            }
        }
        // Normal order weekday
        else {
            for (int i = 0; i < tickets.size(); i++) {
                // Check if premium ticket
                if (tickets.get(i).isPremiumTicket()) {
                    totalPrice = totalPrice + tickets.get(i).getPrice() + 3;
                } else {
                    totalPrice += tickets.get(i).getPrice();
                }
            }
        }

        System.out.println("Total price equals: " + totalPrice);
        return totalPrice;
    }

    public void export(TicketExportFormat exportFormat) {

        if (exportFormat.equals(TicketExportFormat.PLAINTEXT)) {
            String fileName = "tickets.txt";

            try {
                PrintWriter outputStream = new PrintWriter(fileName);
                for (MovieTicket t : tickets) {
                    outputStream.println(t.toString());
                }
                outputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        // Bases on the string representations of the tickets (toString), write
        // the ticket to a file with naming convention Order_<orderNr>.txt of
        // Order_<orderNr>.json
    }
}

