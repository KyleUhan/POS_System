package pos_system;

import java.util.Scanner;

/**
 *
 * @author Kyle
 */
public class CustomerSelfScanner implements MerchandiseScannerStrategy {

    private final int EXIT_VAL = 999;
    ValidationStrategy validationStrategy;
    private final String ERROR = "Item ID Number must not exceed 18";
    private int[] merchandiseNumberArray;
    private double[] merchandiseQuantityArray;

    @Override
    public final void scanItem() {
        validationStrategy = new ValidateRange(0,18);
        int merchNumber;
        double Qtny;
        merchandiseNumberArray = new int[1];
        merchandiseQuantityArray = new double[1];
        Scanner input = new Scanner(System.in);

        int count = 0;
        System.out.println("Enter item number ID(simulate scan id) " + (count + 1) + ":");
        merchandiseNumberArray[count] = input.nextInt();
        checkForCompletedTransaction(merchandiseNumberArray[count]);
        System.out.println("Enter quantity: ");
        merchandiseQuantityArray[count] = input.nextDouble();
        while (merchandiseNumberArray[count] != EXIT_VAL && merchandiseQuantityArray[count] != EXIT_VAL) {
            count++;
            System.out.println("Enter item number ID(simulate scan id) " + (count + 1) + ":");
            merchNumber = input.nextInt();
            checkForCompletedTransaction(merchNumber);
            System.out.println("Enter quantity: ");
            Qtny = input.nextDouble();

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

    private int checkForCompletedTransaction(int e) {
        
        if (e != EXIT_VAL) {
            e = validationStrategy.validateEntry(e);
        }
        return e;
    }
}
