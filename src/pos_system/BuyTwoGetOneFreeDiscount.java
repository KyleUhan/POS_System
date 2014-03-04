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
    public double getAdjustedTotal() {

        double adjustedTotal = (getItemCost() * getQuantity());

        if (getQuantity() >= 3) {
            adjustedTotal = (getItemCost() * getQuantity()) - getAmountSaved();
        }
        return adjustedTotal;
    }

    @Override
    public double getAmountSaved() {

        double savedAmnt = 0;

        if (getQuantity() >= MIN_NEEDED) {
            int salesApplied;
            salesApplied = (int) (getQuantity() / MIN_NEEDED);
            savedAmnt = salesApplied * getItemCost();
        }
        return savedAmnt;
    }

    //Getters and Setters
    @Override
    public final void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public final void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getItemCost() {
        return itemCost;
    }

}
