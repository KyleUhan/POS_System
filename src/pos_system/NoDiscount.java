/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_system;

/**
 *
 * @author Kyle
 */
public class NoDiscount implements DiscountStrategy {

    private double quantity;
    private double itemCost;

    @Override
    public double getAdjustedTotal() {

        return getItemCost();
    }

    @Override
    public double getAmountSaved() {
        double savedAmnt = 0;

        return savedAmnt;

    }

    //Getters and Setters
    public final void setQuantity(double quantity) {
        this.quantity = quantity;
    }

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
