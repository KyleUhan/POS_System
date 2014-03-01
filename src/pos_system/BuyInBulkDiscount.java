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
public class BuyInBulkDiscount implements DiscountStrategy {

    private double discountPercent = .1;
    private double quantity;
    private double minBulkAmount = 5;
    private double itemCost;

//    public BuyInBulkDiscount(double itemCost, double quantity, double minBulkAmount) {
//        setQuantity(quantity);
//        setItemCost(itemCost);
//        setMinBulkAmount(minBulkAmount);
//    }

    @Override
    public double getAdjustedTotal() {
        
        

        double adjustedTotal = (getItemCost() * getQuantity());

        if (getQuantity() >= getMinBulkAmount()) {
            adjustedTotal = getItemCost() * getQuantity() - getAmountSaved();
        }
        
        new DecimalFormat("##.##").format(adjustedTotal);
        return adjustedTotal;
    }

    @Override
    public double getAmountSaved() {

        double savedAmnt = 0;

        if (getQuantity() >= getMinBulkAmount()) {
            savedAmnt = getItemCost() * getQuantity() * getDiscountPercent();
        }
        new DecimalFormat("##.##").format(savedAmnt);
        return savedAmnt;

    }

    //Getters and Setters
    @Override
    public final void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public final void setMinBulkAmount(double minBulkAmount) {
        this.minBulkAmount = minBulkAmount;
    }

    @Override
    public final void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getMinBulkAmount() {
        return minBulkAmount;
    }

    public double getItemCost() {
        return itemCost;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    //Testing code
//    public static void main(String[] args) {
//        DiscountStrategy ds = new BuyInBulkDiscount(10.00, 3, 4);
//        System.out.println("Amn saved: " + ds.getAmountSaved());
//        System.out.println("New total: " + ds.getAdjustedTotal());
//    }

}
