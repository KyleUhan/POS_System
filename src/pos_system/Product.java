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
    //private DiscountStrategy[] discountType
          //  = {new NoDiscount(), new BuyInBulkDiscount(),
            //    new BuyTwoGetOneFreeDiscount(), new PercentDiscount()};
    private String productID;
    private String productInfo;
    private double productPrice;

    private double amountSaved;
    private double adjustedTotal;

    public Product(String productID, String productInfo, double productPrice, DiscountStrategy discountStrategy) {
        
        setProductID(productID);
        this.setProductInfo(productInfo);
        this.setProductPrice(productPrice);
        this.setDiscountStrategy(discountStrategy);
    }

    
    
    public void applyDiscount(int typeDiscount, MerchandiseScannerStrategy mss, int arrayPos) {
        double amntSaved;
        double newTotal;
        setDiscountStrategy(getDiscountType()[typeDiscount]);
        amntSaved = getDiscountStrategy().getAmountSaved(getProductPrice(), mss.getMerchandiseQuantityArray()[arrayPos]);
        newTotal = getDiscountStrategy().getAdjustedTotalAfterDiscount(getProductPrice(), mss.getMerchandiseQuantityArray()[arrayPos]);
        setAmountSaved(amntSaved);
        setAdjustedTotal(newTotal);

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
        //getDiscountStrategy().getAdjustedTotalAfterDiscount();
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

    public double getAmountSaved() {
        return amountSaved;
    }

    public void setAmountSaved(double amountSaved) {
        this.amountSaved = amountSaved;
    }

    public double getAdjustedTotal() {
        return adjustedTotal;
    }

    public void setAdjustedTotal(double adjustedTotal) {
        this.adjustedTotal = adjustedTotal;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    

}
