package system;

import java.util.TreeMap;

//pricing rules template
public abstract class PricingRules extends Items {
	protected TreeMap<Character, Discount> discounts = new TreeMap<Character, Discount>();

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
		items.put(item.ID, item);
		discounts.put(item.ID, discount);
	}

	// delete item with discount
	public void removeItem(char key) {
		items.remove(key);
		discounts.remove(key);
	}
//calculate price for all items of the type
	public float calculateSubtotal(char key, int count) {
		float price = 0;
		if (discounts.get(key) != null) {
			price = discounts.get(key).getDiscountedPrice(items.get(key), count);
		} else
			price = items.get(key).getPrice() * count;
		return price;
	}
}
