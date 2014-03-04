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

    @Override
    public double getAdjustedTotalAfterDiscount(double itemCost, double quantity) {

        return itemCost;
    }

    @Override
    public double getAmountSaved(double itemCost, double quantity) {

        double savedAmnt = 0;

        return savedAmnt;

    }

}
