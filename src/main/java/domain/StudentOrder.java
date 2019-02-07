package domain;

public class StudentOrder extends MyOrder {
    public StudentOrder(int orderNr) {
        this.orderNr = orderNr;
        calculatePriceBehavior = new CalculatePriceStudent();
    }
}
