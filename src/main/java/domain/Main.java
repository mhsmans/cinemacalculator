package domain;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Make movie");
        Movie movie = new Movie("IO");

        System.out.println("Add movie to screening");
        LocalDateTime date = LocalDateTime.now();
        MovieScreening screening = new MovieScreening(movie, date, 10.00);

        System.out.println("Create tickets");
        MovieTicket normalTicket = new MovieTicket(screening, false, 5, 1);
        MovieTicket premiumTicket = new MovieTicket(screening, true, 5, 2);
        MovieTicket normalTicket2 = new MovieTicket(screening, false, 5, 3);
        MovieTicket normalTicket3 = new MovieTicket(screening, false, 5, 4);
        MovieTicket normalTicket4 = new MovieTicket(screening, false, 5, 5);

        System.out.println("Create order");
        Order order = new Order(1, false);
        order.addSeatReservation(normalTicket);
        order.addSeatReservation(premiumTicket);
        order.addSeatReservation(normalTicket2);
        order.addSeatReservation(normalTicket3);
        order.addSeatReservation(normalTicket4);

        order.calculatePrice();
        order.export(TicketExportFormat.PLAINTEXT);
    }
}