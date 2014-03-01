
package pos_system;

/**
 *
 * @author Kyle
 */
public interface MerchandiseScannerStrategy {

    public abstract void scanItem();

    public abstract int[] getMerchandiseNumberArray();

    public abstract double[] getMerchandiseQuantityArray();

    public abstract int getTotalAmountOfScannedProducts();
}
