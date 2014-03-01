package pos_system;

/**
 *
 * @author Kyle
 */
public class LineItem {

    private RecordStorageStrategy rst;
    private String item;
    private String discountInfo;
    private double total;
    private static int SCAN_ARRAY_POSITION = 0;

    public LineItem() {
        SCAN_ARRAY_POSITION++;
    }

    public RecordStorageStrategy getRst() {
        return rst;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setRst(RecordStorageStrategy rst) {
        this.rst = rst;
    }

    public String getDiscountInfo() {
        return discountInfo;
    }

    public void setDiscountInfo(String discountInfo) {
        this.discountInfo = discountInfo;
    }

    public void setItem(MerchandiseScannerStrategy mss) {
        setRst(new FakeDatabaseRetrieval());
        getRst().getStoreProduct(mss, (SCAN_ARRAY_POSITION - 1));
        setItem(getRst().getProduct().getProductInfo() + " "
                + getRst().getProduct().getProductPrice() + "           "
                + mss.getMerchandiseQuantityArray()[SCAN_ARRAY_POSITION - 1] + "           "
                + getRst().getProduct().getAmountSaved() + "          "
                + getRst().getProduct().getAdjustedTotal());
        setTotal(getRst().getProduct().getAdjustedTotal());

    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    

}
