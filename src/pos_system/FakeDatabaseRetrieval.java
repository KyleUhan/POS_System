package pos_system;

/**
 *
 * @author Kyle
 */
public class FakeDatabaseRetrieval implements RecordStorageStrategy {

    private Product[] products = {
        new Product("000", "Shoes", 55.95, new BuyInBulkDiscount()),
        new Product("001", "Socks", 3.99, new PercentDiscount()),
        new Product("002", "Pants", 34.55, new BuyTwoGetOneFreeDiscount()),
        new Product("003", "Shorts", 28.99, new PercentDiscount()),
        new Product("004", "Underwear", 4.99, new NoDiscount()),
        new Product("005", "Belt", 19.99, new NoDiscount()),
        new Product("006", "T-Shirt", 15.35, new BuyInBulkDiscount()),
        new Product("007", "Long Sleeve Shirt", 19.99, new BuyInBulkDiscount(40, 4)),
        new Product("008", "Sweater", 22.99, new BuyTwoGetOneFreeDiscount()),
        new Product("009", "Dress Coat", 105.95, new BuyTwoGetOneFreeDiscount()),
        new Product("010", "Winter Coat", 78.50, new NoDiscount()),
        new Product("011", "Wind Breaker", 26.99, new PercentDiscount(30)),
        new Product("012", "Tie", 13.99, new BuyInBulkDiscount()),
        new Product("013", "Scarf", 12.35, new PercentDiscount()),
        new Product("014", "Hat", 19.05, new PercentDiscount()),
        new Product("015", "Wrist Watch", 75.00, new PercentDiscount(40)),
        new Product("016", "Bracelet", 55.60, new NoDiscount()),
        new Product("017", "Necklace", 78.45, new NoDiscount()),
        new Product("018", "Sun Glasses", 14.99, new BuyInBulkDiscount())
    };

    @Override
    public final Product locateStoreProduct(final MerchandiseScannerStrategy mss, final int scannedPosition) {
        return this.getProducts()[mss.getMerchandiseNumberArray()[scannedPosition]];
    }

    @Override
    public final int getDBSize() {
        return this.getProducts().length;
    }

    public final Product[] getProducts() {
        return products;
    }

    public final void setProducts(final Product[] products) {
        this.products = products;
    }
}
