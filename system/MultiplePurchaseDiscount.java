package system;

import java.math.BigDecimal;

//discount template for discounts mentioned in the excercise.
public class MultiplePurchaseDiscount implements Discount {

	private final int interval;
	private final BigDecimal bundlePrice;

	MultiplePurchaseDiscount(int interval, float bundlePrice) {
		this.interval = interval;
		this.bundlePrice = new BigDecimal(bundlePrice);
	}

	@Override
	public BigDecimal getDiscountedPrice(Item item, int itemCount) {
		int bundleCount = itemCount / interval;
		int undiscountedItems = itemCount % interval;
		// count
		return bundlePrice.multiply(new BigDecimal(bundleCount))
				.add(item.getPrice().multiply(new BigDecimal(undiscountedItems)));

	}

}
