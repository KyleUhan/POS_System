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

    public LineItem(final RecordStorageStrategy rss, final MerchandiseScannerStrategy mss, final int arrayPosition) {
        setRss(rss);
        setProduct(locateProduct(mss, arrayPosition));
    }

    public final double getAdjustedTotalAfterDiscount(final MerchandiseScannerStrategy mss, final int arrayPosition) {
        return getProduct().getDiscountStrategy().getAdjustedTotalAfterDiscount(getProduct().getProductPrice(), mss.getMerchandiseQuantityArray()[arrayPosition]);
    }

    public final double getAmountSaved(final MerchandiseScannerStrategy mss, final int arrayPosition) {
        return getProduct().getDiscountStrategy().getAmountSaved(getProduct().getProductPrice(), mss.getMerchandiseQuantityArray()[arrayPosition]);
    }

    public final RecordStorageStrategy getRss() {
        return rss;
    }

    public final String getItem() {
        return entireLineItem;
    }

    public final void setItem(final String item) {
        this.entireLineItem = item;
    }

    public final void setRss(final RecordStorageStrategy rss) {
        this.rss = rss;
    }

    private Product locateProduct(final MerchandiseScannerStrategy mss, final int arrayPosition) {

        return rss.locateStoreProduct(mss, arrayPosition);
    }

    public final double getSubTotal() {
        return subTotal;
    }

    public final void setSubTotal(final double subTotal) {
        this.subTotal = subTotal;
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(final Product product) {
        this.product = product;
    }
}
