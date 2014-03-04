package pos_system;

import java.text.DateFormat;
import java.text.DecimalFormat;
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
    public void populateReceipt(MerchandiseScannerStrategy mss, RecordStorageStrategy rss) {
        eachLine = new LineItem[mss.getTotalAmountOfScannedProducts()];

        for (int i = 0; i < mss.getTotalAmountOfScannedProducts(); i++) {
            eachLine[i] = new LineItem();
            eachLine[i].setRss(rss);
            eachLine[i].setItem(mss, i);
        }
    }

    @Override
    public void showReceiptForItems(MerchandiseScannerStrategy mss, RecordStorageStrategy rss) {
        double overAllTotal = 0;
        int i = 0;
        //***TO DO - SET ALL FORMATTING IN A FORMAT STRATEGY***
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Store Receipt\n" + getStoreInfo() + "\n" + dateFormat.format(date)
                + "\n------------------------------------------------------------------------------------");
        System.out.println("ID  ----   Product   ----   Price  ----  Quantity  ---- "
                + "Sale Amount  ----  Total\n"
                + "------------------------------------------------------------------------------------");

        populateReceipt(mss, rss);
        
        for (LineItem eachLine1 : eachLine) {
            System.out.println("000-" + mss.getMerchandiseNumberArray()[i]
                    + "      " + eachLine1.getItem());
            overAllTotal += eachLine1.getTotal();
            i++;
        }
        System.out.println("\nTOTAL: " + new DecimalFormat("##.##").format(overAllTotal));

    }

    //Getters and Setters
    public void setStoreInfo(final String storeInfo) {
        this.storeInfo = storeInfo;
    }

    public LineItem[] getLineItem() {
        return eachLine;
    }

    public void setEachLine(final LineItem[] eachLine) {
        this.eachLine = eachLine;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public LineItem[] getEachLine() {
        return eachLine;
    }

}
