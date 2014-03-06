package pos_system;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kyle
 */
public class ReceiptConsoleOutput implements ReceiptStrategy {

    private String storeInfo = "Krohls Department Store";
    private static final double SALES_TAX = 5.5;
    private LineItem[] eachLine;

    @Override
    public final void populateReceipt(final MerchandiseScannerStrategy mss, final RecordStorageStrategy rss) {
        eachLine = new LineItem[mss.getTotalAmountOfScannedProducts()];

        for (int i = 0; i < mss.getTotalAmountOfScannedProducts(); i++) {
            eachLine[i] = new LineItem(rss, mss, i);
        }
    }

    //***TO DO - SET ALL FORMATTING IN A FORMAT STRATEGY***
    @Override
    public final void showReceiptForItems(final MerchandiseScannerStrategy mss, final RecordStorageStrategy rss) {
        double overAllTotal = 0;
        int i = 0;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Store Receipt\n" + getStoreInfo() + "\n" + dateFormat.format(date)
                + "\n----------------------------------------------------------------------------------------");
        System.out.println("ID       \tProduct     \tPrice     \tQuantity     \t"
                + "Sale Amount     Total\n"
                + "----------------------------------------------------------------------------------------");

        populateReceipt(mss, rss);

        for (LineItem eachLine1 : eachLine) {
            System.out.println(eachLine1.getProduct().getProductID()
                    + "     \t" + eachLine1.getProduct().getProductInfo()
                    + "     \t" + eachLine1.getProduct().getProductPrice()
                    + "     \t" + mss.getMerchandiseQuantityArray()[i]
                    + "     \t" + eachLine1.getAmountSaved(mss, i)
                    + "     \t" + eachLine1.getAdjustedTotalAfterDiscount(mss, i));
            overAllTotal += eachLine1.getAdjustedTotalAfterDiscount(mss, i);
            i++;
        }
        System.out.println("\nTOTAL: \t\t$" + new DecimalFormat("##.##").format(overAllTotal));
        System.out.println("Sales tax: \t" + SALES_TAX);
        double grandTotal = overAllTotal * (SALES_TAX/100);
        System.out.println("FINAL TOTAL: \t$" + new DecimalFormat("##.##").format(overAllTotal + grandTotal));

    }

    //Getters and Setters
    public final void setStoreInfo(final String storeInfo) {
        this.storeInfo = storeInfo;
    }

    public final LineItem[] getLineItem() {
        return eachLine;
    }

    public final void setEachLine(final LineItem[] eachLine) {
        this.eachLine = eachLine;
    }

    public final String getStoreInfo() {
        return storeInfo;
    }

    public final LineItem[] getEachLine() {
        return eachLine;
    }
}
