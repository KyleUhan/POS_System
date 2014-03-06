package pos_system;

import java.util.Scanner;

/**
 *
 * @author Kyle
 */
public class CustomerSelfScanner implements MerchandiseScannerStrategy {

    private final int EXIT_VAL = 999;
    private int[] merchandiseNumberArray;
    private double[] merchandiseQuantityArray;

    @Override
    public final void scanItem(final RecordStorageStrategy rss) {
        ValidationStrategy vs1 = new ValidateRange(0, rss.getDBSize() - 1);
        ValidationStrategy vs2 = new ValidateRange(0.1, 999.0);
        int merchNumber;
        double Qtny;
        merchandiseNumberArray = new int[1];
        merchandiseQuantityArray = new double[1];
        Scanner input = new Scanner(System.in);

        int count = 0;
        System.out.println("Enter item number ID(simulate scan id) " + (count + 1) + ":");
        merchandiseNumberArray[count] = input.nextInt();
        checkForCompletedTransaction(merchandiseNumberArray[count], vs1);
        System.out.println("Enter quantity: ");
        merchandiseQuantityArray[count] = input.nextDouble();
        checkForCompletedTransaction(merchandiseQuantityArray[count], vs2);

        while (merchandiseNumberArray[count] != EXIT_VAL && merchandiseQuantityArray[count] != EXIT_VAL) {
            count++;
            System.out.println("Enter item number ID(simulate scan id) " + (count + 1) + ":");
            merchNumber = input.nextInt();
            checkForCompletedTransaction(merchNumber, vs1);
            System.out.println("Enter quantity: ");
            Qtny = input.nextDouble();
            checkForCompletedTransaction(Qtny, vs2);
            if (merchNumber == EXIT_VAL || Qtny == EXIT_VAL) {
                break;
            }

            addToMerchandiseNumberArray(merchNumber);
            addToMerchandiseQuantityArray(Qtny);

            System.out.println("-----------------");
        }

        System.out.println("\nScan Complete...\n");

    }

    //Allows for dynamic array expansion
    private void addToMerchandiseNumberArray(final int item) {
        int[] tempItems = new int[merchandiseNumberArray.length + 1];
        System.arraycopy(merchandiseNumberArray, 0, tempItems, 0, merchandiseNumberArray.length);
        tempItems[merchandiseNumberArray.length] = item;
        merchandiseNumberArray = tempItems;
    }

    //Allows for dynamic array expansion
    private void addToMerchandiseQuantityArray(final double qty) {
        double[] tempItems = new double[merchandiseQuantityArray.length + 1];
        System.arraycopy(merchandiseQuantityArray, 0, tempItems, 0, merchandiseQuantityArray.length);
        tempItems[merchandiseQuantityArray.length] = qty;
        merchandiseQuantityArray = tempItems;
    }

    @Override
    public final int[] getMerchandiseNumberArray() {
        return merchandiseNumberArray;
    }

    @Override
    public final double[] getMerchandiseQuantityArray() {
        return merchandiseQuantityArray;
    }

    @Override
    public final int getTotalAmountOfScannedProducts() {
        return merchandiseNumberArray.length;
    }

    //To ensure exit command is not the value to validate
    private int checkForCompletedTransaction(int e, ValidationStrategy vs) {

        if (e != EXIT_VAL) {
            e = vs.validateEntry(e);
        }
        return e;
    }

    //To ensure exit command is not the value to validate
    private double checkForCompletedTransaction(double e, ValidationStrategy vs) {

        if (e != EXIT_VAL) {
            e = vs.validateEntry(e);
        }
        return e;
    }
}
