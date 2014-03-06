package pos_system;

/**
 *
 * @author Kyle
 */
public interface MerchandiseScannerStrategy {

    public abstract void scanItem(RecordStorageStrategy rss);

    public abstract int[] getMerchandiseNumberArray();

    public abstract double[] getMerchandiseQuantityArray();

    public abstract int getTotalAmountOfScannedProducts();
}
