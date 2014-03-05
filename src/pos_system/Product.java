package pos_system;

/**
 *
 * @author Kyle
 */
public class Product {

    private DiscountStrategy discountStrategy;
    private String productID;
    private String productInfo;
    private double productPrice;

    public Product(String productID, String productInfo, double productPrice, DiscountStrategy discountStrategy) {
        setProductID(productID);
        setProductInfo(productInfo);
        setProductPrice(productPrice);
        setDiscountStrategy(discountStrategy);
    }

    //Getters and Setters
    public final String getProductInfo() {
        return productInfo;
    }

    public final double getProductPrice() {
        return productPrice;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setProductInfo(final String productInfo) {
        this.productInfo = productInfo;
    }

    public final void setProductPrice(final double productPrice) {
        this.productPrice = productPrice;
    }

    public final void setDiscountStrategy(final DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public final String getProductID() {
        return productID;
    }

    public final void setProductID(final String productID) {
        this.productID = productID;
    }
}
