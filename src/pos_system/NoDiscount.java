
package pos_system;

/**
 *
 * @author Kyle
 */
public class NoDiscount implements DiscountStrategy {

    @Override
    public double getAdjustedTotalAfterDiscount(final double itemCost,final double quantity) {

        return itemCost;

    }

    @Override
    public double getAmountSaved(final double itemCost,final double quantity) {

        double savedAmnt = 0;

        return savedAmnt;

    }
}
