package pos_system;

/**
 *
 * @author Kyle
 */
public interface DiscountStrategy {

    public abstract double getAdjustedTotalAfterDiscount(double itemCost, double quantity);

    public abstract double getAmountSaved(double itemCost, double quantity);

}
