package pos_system;

/**
 *
 * @author Kyle
 */
public class RealDatabaseRetrieval implements RecordStorageStrategy {

    @Override
    public Product locateStoreProduct(MerchandiseScannerStrategy mss, int scannedPosition) {
        System.out.println("Unable to Access DB at this time - DB not configured.");
        return null;
    }

    @Override
    public int getDBSize() {
        return 0;
    }
}
