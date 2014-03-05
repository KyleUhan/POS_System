package pos_system;

/**
 *
 * @author Kyle
 */
public class NoDiscount implements DiscountStrategy {

    @Override
    public final double getAdjustedTotalAfterDiscount(final double itemCost, final double quantity) {

        return itemCost;

    }

    @Override
    public final double getAmountSaved(final double itemCost, final double quantity) {

        double savedAmnt = 0;

        return savedAmnt;

    }
}
