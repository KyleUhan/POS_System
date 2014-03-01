package pos_system;

/**
 *
 * @author Kyle
 */
public class FakeDatabaseRetrieval implements RecordStorageStrategy {

    private Product product;

    private final String[] storeItemNames = {"Shoes            ", "Socks            ",
        "Pants            ", "Shorts           ", "Underwear        ",
        "Belt             ", "T-Shirt          ", "Long Sleeve Shirt", "Sweater          ",
        "Dress Coat       ", "Winter Coat      ", "Wind Breaker     ", "Tie              ",
        "Scarf            ", "Hat              ", "Wrist Watch      ", "Bracelet         ",
        "Necklace         ", "Sun Glasses      "};
    private final double[] storeItemPrice = {55.95, 3.99, 34.55, 28.99, 4.99, 19.99,
        15.35, 19.99, 22.99, 105.95, 78.50, 26.99,
        13.99, 12.35, 19.05, 75.00, 55.60, 78.45, 14.99};
    private final int[] productDiscountType = {1, 3, 2, 3, 0, 0, 1, 1, 2, 2, 0, 3, 1, 3, 3, 3, 0, 0, 1};

    @Override
    public final void getStoreProduct(MerchandiseScannerStrategy mss, int scannedPosition) {
        
        setProduct(new Product());
        getProduct().setProductInfo(getStoreItemNames(mss.getMerchandiseNumberArray()[scannedPosition]));
        getProduct().setProductPrice(getProductPrice(mss.getMerchandiseNumberArray()[scannedPosition]));
        getProduct().applyDiscount(getProductDiscountType()[scannedPosition], mss, scannedPosition);
        
    }
    
    @Override
    public final double getProductPrice(int merchandiseNumber) {
        return storeItemPrice[merchandiseNumber];
    }

    @Override
    public int getDBSize() {
        return storeItemNames.length;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStoreItemNames(int merchNumber) {
        return storeItemNames[merchNumber];
    }

    public double[] getStoreItemPrice() {
        return storeItemPrice;
    }

    public int[] getProductDiscountType() {
        return productDiscountType;
    }

}
