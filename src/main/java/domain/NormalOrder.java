package domain;

public class NormalOrder extends MyOrder {
    public NormalOrder(int orderNr) {
        this.orderNr = orderNr;
        calculatePriceBehavior = new CalculatePriceNormal();
    }
}
