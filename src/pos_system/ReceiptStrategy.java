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
public interface ReceiptStrategy {

    public abstract void showReceiptForItems(MerchandiseScannerStrategy mss, RecordStorageStrategy rss);

    public abstract void populateReceipt(MerchandiseScannerStrategy mss, RecordStorageStrategy rss);
}
