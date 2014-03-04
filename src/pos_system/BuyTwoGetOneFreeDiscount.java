package pos_system;

import java.text.DecimalFormat;

/**
 *
 * @author Kyle
 */
public class BuyTwoGetOneFreeDiscount implements DiscountStrategy {

    private final double MIN_NEEDED = 3;
    private double quantity;
    private double itemCost;

    @Override
    public double getAdjustedTotalAfterDiscount(double itemCost, double quantity) {

        double adjustedTotal = (itemCost * quantity);

        if (quantity >= 3) {
            adjustedTotal = (itemCost * quantity) - getAmountSaved(itemCost, quantity);
        }
        return adjustedTotal;
    }

    @Override
    public double getAmountSaved(double itemCost, double quantity) {

        double savedAmnt = 0;

        if (quantity >= MIN_NEEDED) {
            int salesApplied;
            salesApplied = (int) (quantity / MIN_NEEDED);
            savedAmnt = salesApplied * itemCost;
        }
        return savedAmnt;
    }

}
