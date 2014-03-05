/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_system;

/**
 *
 * @author Owner
 */
public interface RecordStorageStrategy {

    public abstract Product locateStoreProduct(MerchandiseScannerStrategy mss, int scannedPosition);

    public abstract int getDBSize();
}
