package pos_system;

/**
 *
 * @author Kyle
 */
public class Register {

    private final String ACTIVATED_REGISTER = "Register activated\n";

    //Output strategy
    private ReceiptStrategy receipt;
    //Input strategy
    private MerchandiseScannerStrategy merchandiseScanner;

    public Register() {
        System.out.println(ACTIVATED_REGISTER);
    }

    public final void startNewSale(final MerchandiseScannerStrategy mss, final ReceiptStrategy rs, RecordStorageStrategy rss) {
        setMerchandiseScanner(mss);
        getMerchandiseScanner().scanItem();
        setReceipt(rs);
        completeTransaction(rss);
    }

    //Pass scanned item values to Output Strategy
    public final void completeTransaction(RecordStorageStrategy rss) {
        getReceipt().showReceiptForItems(getMerchandiseScanner(), rss);
    }

    //Getters and Setters
    public void setReceipt(final ReceiptStrategy receipt) {
        this.receipt = receipt;
    }

    public void setMerchandiseScanner(final MerchandiseScannerStrategy merchandiseScanner) {
        this.merchandiseScanner = merchandiseScanner;
    }

    public ReceiptStrategy getReceipt() {
        return receipt;
    }

    public MerchandiseScannerStrategy getMerchandiseScanner() {
        return merchandiseScanner;
    }

}
