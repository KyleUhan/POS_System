package pos_system;

import java.text.DecimalFormat;

/**
 *
 * @author Kyle
 */
public class LineItem {

    private RecordStorageStrategy rss;
    private Product product;
    private String entireLineItem;
    private double total;

    public LineItem(RecordStorageStrategy rss, MerchandiseScannerStrategy mss, int arrayPosition) {
        setRss(rss);
        product = locateProduct(mss, arrayPosition);
    
    }

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

    public Product locateProduct(MerchandiseScannerStrategy mss, int arrayPosition) {
        
        return rss.locateStoreProduct(mss, arrayPosition);
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    

}
