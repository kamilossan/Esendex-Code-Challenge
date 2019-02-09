package system;

//discount template for discounts mentioned in the excercise.
public class MultiplePurchaseDiscount implements Discount {
	MultiplePurchaseDiscount(int interval, float bundlePrice){
		this.interval = interval;
		this.bundlePrice = bundlePrice;
	}
	
	private final int interval;
	private final float bundlePrice;

	@Override
	public float getDiscountedPrice(Item item, int itemCount) {
		//how many times discount occurs, casting prevents rounding upward
		int bundleCount = (int)(itemCount/interval);
		int undiscountedItems = (int)itemCount%interval;
		//count 
		return bundleCount*bundlePrice+undiscountedItems*item.getPrice();
		
	}

	@Override
	public Discount getDiscount() {
		return this;
	}

	@Override
	public String getDiscountProperties() {
		// TODO Auto-generated method stub
		return "Get "+interval+" products at the price of "+bundlePrice;
	}

}
