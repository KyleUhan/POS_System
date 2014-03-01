/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos_system;

/**
 *
 * @author Owner
 */
public interface DiscountStrategy {
    
    public abstract double getAdjustedTotal();
    
    public abstract double getAmountSaved();
    
    public abstract void setQuantity(double quantity);
    
    public abstract void setItemCost(double itemCost);
    
}
