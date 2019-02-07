package TestResources;

import domain.*;

import java.time.LocalDateTime;
import java.time.Month;

public class OrderResources {
    MyOrder order1;
    private MyOrder order2;
    private MyOrder order3;

    public OrderResources() {
        Movie movie1 = new Movie("Jungle book");
        LocalDateTime date1 = LocalDateTime.of(2019, Month.FEBRUARY, 7, 15, 50);
        LocalDateTime date2 = LocalDateTime.of(2019, Month.FEBRUARY, 2, 15, 50);

        MovieScreening screening1 = new MovieScreening(movie1, date1, 10);
        MovieScreening screening2 = new MovieScreening(movie1, date2, 10);

        MovieTicket ticket1 = new MovieTicket(screening1, true, 1, 1);
        MovieTicket ticket2 = new MovieTicket(screening1, true, 1, 2);
        MovieTicket ticket3 = new MovieTicket(screening1, false, 1, 3);
        MovieTicket ticket4 = new MovieTicket(screening1, false, 1, 4);

        MovieTicket ticket5 = new MovieTicket(screening2, true, 1, 1);
        MovieTicket ticket6 = new MovieTicket(screening2, true, 1, 2);
        MovieTicket ticket7 = new MovieTicket(screening2, false, 1, 3);
        MovieTicket ticket8 = new MovieTicket(screening2, true, 1, 4);

        order1 = new StudentOrder(1);
        order1.addSeatReservation(ticket1);
        order1.addSeatReservation(ticket2);
        order1.addSeatReservation(ticket3);
        order1.addSeatReservation(ticket4);

        order2 = new NormalOrder(2);
        order2.addSeatReservation(ticket1);
        order2.addSeatReservation(ticket2);
        order2.addSeatReservation(ticket3);
        order2.addSeatReservation(ticket4);

        order3 = new WeekendOrder(3);
        order3.addSeatReservation(ticket5);
        order3.addSeatReservation(ticket6);
        order3.addSeatReservation(ticket7);
        order3.addSeatReservation(ticket8);

    }

    public MyOrder getOrder1() {
        return this.order1;
    }

    public MyOrder getOrder2() {
        return this.order2;
    }

    public MyOrder getOrder3() {
        return this.order3;
    }
}
