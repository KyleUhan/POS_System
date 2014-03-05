package pos_system;

/**
 *
 * @author Kyle
 */
public class StartUp {

    public static void main(String[] args) {
        Register register = new Register();
        //Send register the type of input, output strategy, and where the info will be.
        register.startNewSale(new CustomerSelfScanner(), new ReceiptConsoleOutput(), new FakeDatabaseRetrieval());
    }
}
