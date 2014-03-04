
package pos_system;


/**
 *
 * @author Kyle
 */
public class BuyInBulkDiscount implements DiscountStrategy {

    private double discountPercent = .1;
    private double minBulkAmount = 5;

    @Override
    public double getAdjustedTotalAfterDiscount(double itemCost, double quantity) {

        double adjustedTotal = (itemCost * quantity);

        if (quantity >= getMinBulkAmount()) {
            adjustedTotal = itemCost * quantity - getAmountSaved(itemCost, quantity);
        }

        return adjustedTotal;
    }

    @Override
    public double getAmountSaved(double itemCost, double quantity) {

        double savedAmnt = 0;

        if (quantity >= getMinBulkAmount()) {
            savedAmnt = itemCost * quantity * getDiscountPercent();
        }

        return savedAmnt;

    }

    //Getters and Setters
    public final void setMinBulkAmount(double minBulkAmount) {
        this.minBulkAmount = minBulkAmount;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getMinBulkAmount() {
        return minBulkAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

}
