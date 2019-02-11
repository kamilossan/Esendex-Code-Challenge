package system;

import java.math.BigDecimal;
import java.util.TreeMap;

//checkout handling class, functions overloaded to accept both entire item objects or item ID's as parameters
public class Checkout {
	// total price
	private BigDecimal total = new BigDecimal(0);
	// inherited pricings
	private PricingRules pricingRules;
	// items in basket
	private TreeMap<Character, Integer> basket;

	Checkout(PricingRules pricingRules) {
		this.pricingRules = pricingRules;
		createEmptyBasket();
	}

	// add item to basket
	public void scan(Item item) {
		if (pricingRules.items.getItems().containsKey(item.getID())) {
			if (basket.get(item.getID()) == null) {
				basket.put(item.getID(), 0);
			}
			basket.put(item.getID(), basket.get(item.getID()) + 1);
			calculateTotal();
		} else
			System.out.println("no item in database");
	}

	public void scan(char item) {
		if (pricingRules.items.getItems().containsKey(item)) {
			if (basket.get(item) == null) {
				basket.put(item, 0);
			}
			basket.put(item, basket.get(item) + 1);
			calculateTotal();
		} else
			System.out.println("no item in database");
	}

	// remove single item from basket
	public void removeItem(Item item) {
		if (!basket.containsValue(item.getID())) {
			basket.put(item.getID(), 0);
		}
		if (basket.get(item.getID()) > 0) {
			basket.put(item.getID(), (basket.get(item.getID())) - 1);
		} else
			System.out.println("no items left in basket or invalid item");

	}

	public void removeItem(char item) {
		if (!basket.containsValue(item)) {
			basket.put(item, 0);
		}
		if (basket.get(item) > 0) {
			basket.put(item, (basket.get(item)) - 1);
		} else
			System.out.println("no items left in basket or invalid item");

	}

	// empties basket off all products of type item
	public void removeAllItemsOfType(Item item) {
		basket.remove(item.getID());
	}

	public void removeAllItemsOfType(char item) {
		basket.remove(item);
	}

	public void createEmptyBasket() {
		basket = new TreeMap<Character, Integer>();
	}

	public void calculateTotal() {
		total = new BigDecimal(0);
		for (char key : basket.keySet()) {
			total = total.add(pricingRules.calculateSubtotal(key, basket.get(key)));
		}
	}

	// sample checkout
	public static void main(String args[]) {
		Checkout checkout = new Checkout(new ThisWeekPricing());
		checkout.pricingRules.uploadCurrentDatabase(new ItemBase());
		checkout.scan('D');
		checkout.scan('A');
		checkout.scan('B');
		checkout.scan('A');
		checkout.scan('B');
		checkout.scan('A');

		System.out.println(checkout.total);

	}
}
