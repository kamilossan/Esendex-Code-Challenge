package system;

//sample pricing rules extension to implement actual data. can be automated if store database exists.
public class ThisWeekPricing extends PricingRules{
	//item list added here, but adding items could theoretically be done within Items class or imported from store's database.
	Item A = new Item('A', 60);
	Item B = new Item('B', 30);
	Item C = new Item('C', 30);
	Item D = new Item('D', 25);

	
	ThisWeekPricing(){
		//this can be automated if store has a database with items and respective discounts
		addDiscountedItem(A, new MultiplePurchaseDiscount(3, 150));
		addDiscountedItem(B, new MultiplePurchaseDiscount(2, 45));
		addItem(C);
		addItem(D);
	}
}
