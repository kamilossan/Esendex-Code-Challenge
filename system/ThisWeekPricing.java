package system;

//sample pricing rules extension to implement actual data. can be automated if store database exists.
public class ThisWeekPricing extends PricingRules{
	

	
	ThisWeekPricing(){
		//this can be automated if store has a database with items and respective discounts
		addDiscount('A', new MultiplePurchaseDiscount(3, 150));
		addDiscount('B', new MultiplePurchaseDiscount(2, 45));

	}
}
