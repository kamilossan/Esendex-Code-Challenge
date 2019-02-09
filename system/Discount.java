package system;

//discount template. implement to create more discount types
public interface Discount {

abstract float getDiscountedPrice(Item item, int itemCount);
abstract Discount getDiscount();
abstract String getDiscountProperties();

}
