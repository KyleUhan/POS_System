/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_system;

import java.text.DecimalFormat;

/**
 *
 * @author Kyle
 */
public class PercentDiscount implements DiscountStrategy {

    private final int CONVER_TO_PERCENT = 100;
    private double percentAmount;

    @Override
    public double getAdjustedTotalAfterDiscount(double itemCost, double quantity) {

        double adjustedTotal = (itemCost * quantity) - getAmountSaved(itemCost, quantity);

        return adjustedTotal;
    }

    //ADDRESS MAGIC NUMBER
    @Override
    public double getAmountSaved(double itemCost, double quantity) {

        double savedAmnt = itemCost * quantity * getPercentAmount();

        return savedAmnt;
    }

    //Getters and Setters
    public final void setPercentAmount(double percentAmount) {
        this.percentAmount = percentAmount / CONVER_TO_PERCENT;
    }

    public double getPercentAmount() {
        return percentAmount;
    }

}
