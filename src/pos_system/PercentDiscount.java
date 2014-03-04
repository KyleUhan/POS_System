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
    private double quantity;
    private double percentAmount;
    private double itemCost;

    @Override
    public double getAdjustedTotal() {

        double adjustedTotal = (getItemCost() * getQuantity()) - getAmountSaved();

        return adjustedTotal;
    }

    //ADDRESS MAGIC NUMBER
    @Override
    public double getAmountSaved() {

        double savedAmnt = getItemCost() * getQuantity() * getPercentAmount();

        return savedAmnt;
    }

    //Getters and Setters
    @Override
    public final void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public final void setPercentAmount(double percentAmount) {
        this.percentAmount = percentAmount / CONVER_TO_PERCENT;
    }

    @Override
    public final void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPercentAmount() {
        return percentAmount;
    }

    public double getItemCost() {
        return itemCost;
    }

}
