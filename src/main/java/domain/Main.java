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

        System.out.println("Create student order");
        MyOrder order = new StudentOrder(1);
        order.setCalculatePriceBehavior((new CalculatePriceStudent()));
        order.addSeatReservation(normalTicket);
        order.addSeatReservation(premiumTicket);
        order.addSeatReservation(normalTicket2);
        order.addSeatReservation(normalTicket3);
        order.addSeatReservation(normalTicket4);

        System.out.println("Create normal order");
        MyOrder secondOrder = new NormalOrder(2);
        secondOrder.setCalculatePriceBehavior(new CalculatePriceNormal());
        secondOrder.addSeatReservation(normalTicket);
        secondOrder.addSeatReservation(premiumTicket);
        secondOrder.addSeatReservation(normalTicket2);
        secondOrder.addSeatReservation(normalTicket3);
        secondOrder.addSeatReservation(normalTicket4);

        System.out.println("Create weekend order");
        MyOrder thirdOrder = new WeekendOrder(3);
        thirdOrder.setCalculatePriceBehavior(new CalculatePriceWeekend());
        thirdOrder.addSeatReservation(normalTicket);
        thirdOrder.addSeatReservation(premiumTicket);
        thirdOrder.addSeatReservation(normalTicket2);
        thirdOrder.addSeatReservation(normalTicket3);
        thirdOrder.addSeatReservation(normalTicket4);

        order.calculatePrice();
        secondOrder.calculatePrice();
        thirdOrder.calculatePrice();
    }
}