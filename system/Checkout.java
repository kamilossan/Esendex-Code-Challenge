package system;

import java.util.TreeMap;

//checkout handling class, functions overloaded to accept both entire item objects or item ID's as parameters
public class Checkout {
	
	//sample checkout
	public static void main(String args[]){
		Checkout checkout = new Checkout(new ThisWeekPricing());
		checkout.scan('D');
		checkout.scan('A');
		checkout.scan('B');
		checkout.scan('A');
		checkout.scan('B');
		checkout.scan('A');
		
		System.out.println(checkout.total);
		
	}
	Checkout(PricingRules pricingRules){
		this.pricingRules = pricingRules;
	}
	// total price
	public float total = 0;
	// inherited pricings
	PricingRules pricingRules;
	// items in basket
	TreeMap<Character, Integer> basket = new TreeMap<Character, Integer>();

	//add item to basket
	public void scan(Item item) {
		if(pricingRules.items.containsKey(item.ID)){
			if(basket.get(item.ID)==null){
				basket.put(item.ID, 0);
			}
			basket.put(item.ID, basket.get(item.ID) + 1);
			calculateTotal();}
			else System.out.println("no item in database");
	}
	
	public void scan(char item) {
		if(pricingRules.items.containsKey(item)){
		if(basket.get(item)==null){
			basket.put(item, 0);
		}
		basket.put(item, basket.get(item) + 1);
		calculateTotal();}
		else System.out.println("no item in database");
	}

	// remove single item from basket
	public void removeItem(Item item) {
		if(!basket.containsValue(item.ID)){
			basket.put(item.ID, 0);
		}
		if(basket.get(item.ID)>0){
		basket.put(item.ID, (basket.get(item.ID)) - 1);}
		else System.out.println("no items left in basket or invalid item");
	
	}
	public void removeItem(char item) {
		if(!basket.containsValue(item)){
			basket.put(item, 0);
		}
		if(basket.get(item)>0){
		basket.put(item, (basket.get(item)) - 1);}
		else System.out.println("no items left in basket or invalid item");
	
	}


	// empties basket off all products of type item
	public void removeAllItemsOfType(Item item) {
		basket.remove(item.ID);
	}
	public void removeAllItemsOfType(char item) {
		basket.remove(item);
	}

	public void emptyBasket() {
		basket = new TreeMap<Character, Integer>();
	}

	public void calculateTotal() {
		total = 0;
		for (char key : basket.keySet()) {
			total += pricingRules.calculateSubtotal(key, basket.get(key));
		}
	}
}
