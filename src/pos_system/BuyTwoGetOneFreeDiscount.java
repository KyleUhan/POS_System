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
public class BuyTwoGetOneFreeDiscount implements DiscountStrategy {

    private final double MIN_NEEDED = 3;
    private double quantity;
    private double itemCost;

//    public BuyTwoGetOneFreeDiscount(double itemCost, double quantity) {
//        setQuantity(quantity);
//        setItemCost(itemCost);
//    }

    @Override
    public double getAdjustedTotal() {

        double adjustedTotal = (getItemCost() * getQuantity());

        if (getQuantity() >= 3) {
            adjustedTotal = (getItemCost() * getQuantity()) - getAmountSaved();
        }
        
        return adjustedTotal;
    }

    //ADDRESS MAGIC NUMBER
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

    //Testing code
//    public static void main(String[] args) {
//        DiscountStrategy ds = new BuyTwoGetOneFreeDiscount(10.00, 13);
//        System.out.println("Amn saved: " + ds.getAmountSaved());
//        System.out.println("New total: " + ds.getAdjustedTotal());
//    }

}
