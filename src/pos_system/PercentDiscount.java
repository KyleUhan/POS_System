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
public class PercentDiscount implements DiscountStrategy {
    private final int CONVER_TO_PERCENT = 100;
    private double quantity;
    private double percentAmount;
    private double itemCost;

//    public PercentDiscount(double itemCost, double quantity, double percentAmount) {
//        setQuantity(quantity);
//        setItemCost(itemCost);
//        setPercentAmount(percentAmount);
//    }

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
    public final void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public final void setPercentAmount(double percentAmount) {
        this.percentAmount = percentAmount / CONVER_TO_PERCENT;
    }

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

    //Testing code
//    public static void main(String[] args) {
//        DiscountStrategy ds = new PercentDiscount(10.00, 1, 10);
//        System.out.println("Amn saved: " + ds.getAmountSaved());
//        System.out.println("New total: " + ds.getAdjustedTotal());
//    }

}
