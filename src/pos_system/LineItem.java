package pos_system;

import java.text.DecimalFormat;

/**
 *
 * @author Kyle
 */
public class LineItem {

    private RecordStorageStrategy rss;
    private String entireLineItem;
    private double total;

    public RecordStorageStrategy getRss() {
        return rss;
    }

    public String getItem() {
        return entireLineItem;
    }

    public void setItem(String item) {
        this.entireLineItem = item;
    }

    public void setRss(RecordStorageStrategy rss) {
        this.rss = rss;
    }

    
     //***TO DO - SET ALL FORMATTING IN A FORMAT STRATEGY***
    public void setItem(MerchandiseScannerStrategy mss, int arrayPosition) {
        getRss().getStoreProduct(mss, (arrayPosition));
        setItem(getRss().getProduct().getProductInfo() + " "
                + getRss().getProduct().getProductPrice() + "           "
                + mss.getMerchandiseQuantityArray()[arrayPosition] + "           "
                + new DecimalFormat("####.##").format(getRss().getProduct().getAmountSaved()) + "          "
                + new DecimalFormat("####.##").format(getRss().getProduct().getAdjustedTotal()));

        setTotal(getRss().getProduct().getAdjustedTotal());

    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
