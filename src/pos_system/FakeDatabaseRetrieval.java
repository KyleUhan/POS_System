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

    private Product[] products ={
        new Product("000","Shoes",55.95,new BuyInBulkDiscount()),
        new Product("001","Socks",3.99,new PercentDiscount()),
        new Product("002","Pants",34.55,new BuyTwoGetOneFreeDiscount()),
        new Product("003","Shorts",28.99,new PercentDiscount()),
        new Product("004","Underwear",4.99,new NoDiscount()),
        new Product("005","Belt",19.99,new NoDiscount()),
        new Product("006","T-Shirt",15.35,new BuyInBulkDiscount()),
        new Product("007","Long Sleeve Shirt",19.99,new BuyInBulkDiscount()),
        new Product("008","Sweater",22.99,new BuyTwoGetOneFreeDiscount()),
        new Product("009","Dress Coat",105.95,new BuyTwoGetOneFreeDiscount()),
        new Product("010","Winter Coat",78.50,new NoDiscount()),
        new Product("011","Wind Breaker", 26.99,new PercentDiscount()),
        new Product("012","Tie",13.99,new BuyInBulkDiscount()),
        new Product("013","Scarf",12.35,new PercentDiscount()),
        new Product("014","Hat",19.05,new PercentDiscount()),
        new Product("015","Wrist Watch",75.00,new PercentDiscount()),
        new Product("016","Bracelet",55.60,new NoDiscount()),
        new Product("017","Necklace",78.45,new NoDiscount()),
        new Product("018","Sun Glasses",14.99,new BuyInBulkDiscount())
    };
    
    
    @Override
    public final void getStoreProduct(MerchandiseScannerStrategy mss, int scannedPosition) {
        
        getProduct().setProductInfo(getStoreItemNames(mss.getMerchandiseNumberArray()[scannedPosition]));
        getProduct().setProductPrice(getProductPrice(mss.getMerchandiseNumberArray()[scannedPosition]));
        getProduct().applyDiscount(getProductDiscountType()[scannedPosition], mss, scannedPosition);

    }
    
    public Product locateProduct(MerchandiseScannerStrategy mss, int arrayPosition){
        return products[mss.getMerchandiseNumberArray()[4]];
    };
    
    
    @Override
    public Product locateStoreProduct(MerchandiseScannerStrategy mss, int scannedPosition){
        return this.getProducts()[mss.getMerchandiseNumberArray()[scannedPosition]];
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

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    
    public static void main(String[] args) {
        MerchandiseScannerStrategy mss = new CustomerSelfScanner();
        FakeDatabaseRetrieval fd = new FakeDatabaseRetrieval();
 
    }
 

    
}
