package pos_system;

/**
 *
 * @author Kyle
 */
public class LineItem {

    private RecordStorageStrategy rss;
    private Product product;
    private String entireLineItem;
    private double subTotal;

    public LineItem(RecordStorageStrategy rss, MerchandiseScannerStrategy mss, int arrayPosition) {
        setRss(rss);
        product = locateProduct(mss, arrayPosition);
    }

    public double getAdjustedTotalAfterDiscount(MerchandiseScannerStrategy mss, int arrayPosition) {
        return getProduct().getDiscountStrategy().getAdjustedTotalAfterDiscount(getProduct().getProductPrice(), mss.getMerchandiseQuantityArray()[arrayPosition]);
    }

    public double getAmountSaved(MerchandiseScannerStrategy mss, int arrayPosition) {
        return getProduct().getDiscountStrategy().getAmountSaved(getProduct().getProductPrice(), mss.getMerchandiseQuantityArray()[arrayPosition]);
    }

    public RecordStorageStrategy getRss() {
        return rss;
    }

    public String getItem() {
        return entireLineItem;
    }

    public void setItem(final String item) {
        this.entireLineItem = item;
    }

    public final void setRss(final RecordStorageStrategy rss) {
        this.rss = rss;
    }

    private Product locateProduct(final MerchandiseScannerStrategy mss, final int arrayPosition) {

        return rss.locateStoreProduct(mss, arrayPosition);
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(final double subTotal) {
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
