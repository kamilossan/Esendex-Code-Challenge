package system;

import java.math.BigDecimal;
import java.util.TreeMap;

//pricing rules template
public abstract class PricingRules {
	protected Items items = new Items();
	private TreeMap<Character, Discount> discounts = new TreeMap<Character, Discount>();

	public void uploadCurrentDatabase(Items itemBase){
		items = itemBase;
	}
	// add discount to existing item
	public void addDiscount(char item, Discount discount) {
		discounts.put(item, discount);
	}

	// delete discount from item
	public void removeDiscount(char key) {
		discounts.remove(key);
	}

	// add item with discount attached
	public void addDiscountedItem(Item item, Discount discount) {
		items.getItems().put(item.getID(), item);
		discounts.put(item.getID(), discount);
	}

	// delete item with discount
	public void removeItem(char key) {
		items.getItems().remove(key);
		discounts.remove(key);
	}
//calculate price for all items of the type
	public BigDecimal calculateSubtotal(char key, int count) {
		BigDecimal price = new BigDecimal(0);
		if (discounts.get(key) != null) {
			price = discounts.get(key).getDiscountedPrice(items.getItems().get(key), count);
		} else
			price = items.getItems().get(key).getPrice().multiply(new BigDecimal(count));
		return price;
	}
}
