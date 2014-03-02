package pos_system;

/**
 *
 * @author Kyle
 */
public interface DiscountStrategy {

    public abstract double getAdjustedTotal();

    public abstract double getAmountSaved();

    public abstract void setQuantity(double quantity);

    public abstract void setItemCost(double itemCost);

}
