package pos_system;

/**
 *
 * @author Kyle
 */
public class BuyInBulkDiscount implements DiscountStrategy {

    private final int CONVER_TO_PERCENT = 100;
    private double discountPercent = .1;
    private double minBulkAmount = 5;

    public BuyInBulkDiscount() {
    }

    public BuyInBulkDiscount(final double discountPercent, final double minBulkAmount) {
        setDiscountPercent(discountPercent);
        setMinBulkAmount(minBulkAmount);
    }

    @Override
    public final double getAdjustedTotalAfterDiscount(final double itemCost, final double quantity) {

        double adjustedTotal = (itemCost * quantity);

        if (quantity >= getMinBulkAmount()) {
            adjustedTotal = itemCost * quantity - getAmountSaved(itemCost, quantity);
        }

        return adjustedTotal;
    }

    @Override
    public final double getAmountSaved(final double itemCost, final double quantity) {

        double savedAmnt = 0;

        if (quantity >= getMinBulkAmount()) {
            savedAmnt = itemCost * quantity * getDiscountPercent();
        }

        return savedAmnt;

    }

    //Getters and Setters
    public final void setMinBulkAmount(final double minBulkAmount) {
        this.minBulkAmount = minBulkAmount;
    }

    public final void setDiscountPercent(final double discountPercent) {
        this.discountPercent = discountPercent / CONVER_TO_PERCENT;
    }

    public final double getMinBulkAmount() {
        return minBulkAmount;
    }

    public final double getDiscountPercent() {
        return discountPercent;
    }
}
