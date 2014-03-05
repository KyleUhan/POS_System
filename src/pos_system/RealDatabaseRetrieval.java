package pos_system;

/**
 *
 * @author Kyle
 */
public class RealDatabaseRetrieval implements RecordStorageStrategy {

    @Override
    public final Product locateStoreProduct(final MerchandiseScannerStrategy mss, final int scannedPosition) {
        System.out.println("Unable to Access DB at this time - DB not configured.");
        return null;
    }

    @Override
    public final int getDBSize() {
        return 0;
    }
}
