package pos_system;

/**
 *
 * @author Kyle
 */
public class PercentDiscount implements DiscountStrategy {

    private final int CONVER_TO_PERCENT = 100;
    private double percentAmount = .2;

    public PercentDiscount() {
    }

    public PercentDiscount(final double percentAmount) {
        setPercentAmount(percentAmount);
    }

    @Override
    public final double getAdjustedTotalAfterDiscount(final double itemCost,final double quantity) {

        double adjustedTotal = (itemCost * quantity) - getAmountSaved(itemCost, quantity);

        return adjustedTotal;
    }

    @Override
    public final double getAmountSaved(final double itemCost,final double quantity) {

        double savedAmnt = itemCost * quantity * getPercentAmount();

        return savedAmnt;
    }

    //Getters and Setters
    public final void setPercentAmount(final double percentAmount) {
        this.percentAmount = percentAmount / CONVER_TO_PERCENT;
    }

    public final double getPercentAmount() {
        return percentAmount;
    }
}
