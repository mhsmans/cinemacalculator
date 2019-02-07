package domain;

import java.util.ArrayList;

public abstract class MyOrder {
    CalculatePriceBehavior calculatePriceBehavior;
    /*ExportBehavior exportBehavior;*/

    public int orderNr;
    private ArrayList<MovieTicket> tickets;

    public MyOrder() {
        tickets = new ArrayList<>();
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public int getOrderNr() {
        return orderNr;
    }


    public void setCalculatePriceBehavior(CalculatePriceBehavior calculatePriceBehavior) {
        this.calculatePriceBehavior = calculatePriceBehavior;
    }

    /*public void setExportBehavior(ExportBehavior exportBehavior) {
        this.exportBehavior = exportBehavior;
    }*/

    public void calculatePrice() {
        calculatePriceBehavior.calculatePrice(tickets);
    }

    /*public void export() {
        exportBehavior.export();
    }*/
}
