package pos_system;

/**
 *
 * @author Kyle
 */
public class Register {
    //Output and Input

    private ReceiptStrategy receipt;
    private MerchandiseScannerStrategy merchandiseScanner;

    public Register() {
    }

    public final void startNewSale(final MerchandiseScannerStrategy mss, final ReceiptStrategy rs, RecordStorageStrategy rss) {
        setMerchandiseScanner(mss);
        getMerchandiseScanner().scanItem();
        setReceipt(rs);
        completeTransaction(rss);
    }

    //Pass scanned item values to Output Strategy
    public final void completeTransaction(final RecordStorageStrategy rss) {
        getReceipt().showReceiptForItems(getMerchandiseScanner(), rss);
    }

    //Getters and Setters
    public final void setReceipt(final ReceiptStrategy receipt) {
        this.receipt = receipt;
    }

    public final void setMerchandiseScanner(final MerchandiseScannerStrategy merchandiseScanner) {
        this.merchandiseScanner = merchandiseScanner;
    }

    public final ReceiptStrategy getReceipt() {
        return receipt;
    }

    public final MerchandiseScannerStrategy getMerchandiseScanner() {
        return merchandiseScanner;
    }
}
