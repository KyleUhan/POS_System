package pos_system;

import java.util.Scanner;

/**
 *
 * @author Kyle
 */
public class CustomerSelfScanner implements MerchandiseScannerStrategy {

    private final int EXIT_VAL = 999;
    private final String ERROR = "Item ID Number must not exceed 18";

    private int[] merchandiseNumberArray;
    private double[] merchandiseQuantityArray;

    @Override
    public void scanItem() {

        int merchNumber;
        double Qtny;
        merchandiseNumberArray = new int[1];
        merchandiseQuantityArray = new double[1];
        Scanner input = new Scanner(System.in);

        int count = 0;
        System.out.println("Enter item number ID(simulate scan id) " + (count + 1) + ":");
        merchandiseNumberArray[count] = input.nextInt();
        validateEntry(merchandiseNumberArray[count]);
        System.out.println("Enter quantity: ");
        merchandiseQuantityArray[count] = input.nextDouble();

        while (merchandiseNumberArray[count] != EXIT_VAL && merchandiseQuantityArray[count] != EXIT_VAL) {
            count++;
            System.out.println("Enter item number(simulate scan id) " + (count + 1) + ":");
            merchNumber = input.nextInt();
            validateEntry(merchNumber);
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

    //for testing purposes
    public void showArray() {
        for (int i = 0; i < merchandiseNumberArray.length; i++) {
            System.out.println(merchandiseNumberArray[i] + " | " + merchandiseQuantityArray[i]);
        }
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
    public int[] getMerchandiseNumberArray() {
        return merchandiseNumberArray;
    }

    @Override
    public double[] getMerchandiseQuantityArray() {
        return merchandiseQuantityArray;
    }

    @Override
    public int getTotalAmountOfScannedProducts() {
        return merchandiseNumberArray.length;
    }

    private int validateEntry(int e) {
        if (e != EXIT_VAL) {
            if (e > 18 || e < 0) {
                throw new IllegalArgumentException(ERROR);
            }
        }
        return e;
    }

}
