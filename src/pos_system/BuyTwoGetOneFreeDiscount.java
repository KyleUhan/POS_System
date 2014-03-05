package pos_system;

/**
 *
 * @author Kyle
 */
public class BuyTwoGetOneFreeDiscount implements DiscountStrategy {

    private final double MIN_NEEDED = 3;

    @Override
    public final double getAdjustedTotalAfterDiscount(final double itemCost, final double quantity) {

        double adjustedTotal = (itemCost * quantity);

        if (quantity >= 3) {
            adjustedTotal = (itemCost * quantity) - getAmountSaved(itemCost, quantity);
        }
        return adjustedTotal;
    }

    @Override
    public final double getAmountSaved(final double itemCost, final double quantity) {

        double savedAmnt = 0;

        if (quantity >= MIN_NEEDED) {
            int salesApplied;
            salesApplied = (int) (quantity / MIN_NEEDED);
            savedAmnt = salesApplied * itemCost;
        }
        return savedAmnt;
    }
}
