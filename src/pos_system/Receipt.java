package pos_system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kyle
 */
public class Receipt implements ReceiptStrategy {

    private String storeInfo = "Krohls Department Store";
    private LineItem[] eachLine;

    @Override
    public void populateReceipt(MerchandiseScannerStrategy mss) {
        eachLine = new LineItem[mss.getTotalAmountOfScannedProducts()];

        for (int i = 0; i < mss.getTotalAmountOfScannedProducts(); i++) {
            eachLine[i] = new LineItem();
            eachLine[i].setItem(mss);
        }
    }

    @Override
    public void getReceiptForItems(MerchandiseScannerStrategy mss) {
        int i = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Store Receipt\n" + getStoreInfo() + "\n" + dateFormat.format(date)
                + "\n------------------------------------------------");
        System.out.println("ID  ----   Product   ----   Price  ----  Quantity  ---- "
                + "Sale Amount  ----  Total\n"
                + "------------------------------------------------");
        //will have loop of line items here
        populateReceipt(mss);
        for (LineItem eachLine1 : eachLine) {
            System.out.println("000-" + mss.getMerchandiseNumberArray()[i]
                    + "      " + eachLine1.getItem());
            i++;
        }

    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo;
    }

    public LineItem[] getLineItem() {
        return eachLine;
    }

    public void setEachLine(LineItem[] eachLine) {
        this.eachLine = eachLine;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public LineItem[] getEachLine() {
        return eachLine;
    }

}
