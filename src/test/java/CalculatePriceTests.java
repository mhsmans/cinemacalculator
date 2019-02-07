import domain.MyOrder;
import org.junit.jupiter.api.Test;
import TestResources.OrderResources;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatePriceTests {

    @Test
    void CalculatePriceNormalValidResponse() {
        OrderResources resources = new OrderResources();
        MyOrder order = resources.getOrder2();

        double calculatePrice = order.calculatePrice();

        assertEquals(46, calculatePrice);
    }
}
