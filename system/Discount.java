package system;

import java.math.BigDecimal;

//discount template. implement to create more discount types
public interface Discount {

abstract BigDecimal getDiscountedPrice(Item item, int itemCount);


}
