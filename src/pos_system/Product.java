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
public class Product {

    private DiscountStrategy discountStrategy;
    private DiscountStrategy[] discountType = {new NoDiscount(), 
        new BuyInBulkDiscount(), new BuyTwoGetOneFreeDiscount(), new PercentDiscount()};
    private String productInfo;
    private double productPrice;
    

    public String applyDiscount(int typeDiscount, MerchandiseScannerStrategy mss, int arrayPos) {
        double amntSaved;
        double adjustedTotal;
        setDiscountStrategy(getDiscountType()[typeDiscount]);
        getDiscountStrategy().setItemCost(productPrice);
        getDiscountStrategy().setQuantity(mss.getMerchandiseQuantityArray()[arrayPos]);
        amntSaved = getDiscountStrategy().getAmountSaved();
        adjustedTotal = getDiscountStrategy().getAdjustedTotal();
        return amntSaved + " " + adjustedTotal;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public void setProductPrice(double productPrice) {
        //getDiscountStrategy().getAdjustedTotal();
        this.productPrice = productPrice;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public DiscountStrategy[] getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountStrategy[] discountType) {
        this.discountType = discountType;
    }
    
    
    
    

}
