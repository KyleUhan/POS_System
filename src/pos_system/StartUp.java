package pos_system;

/**
 *
 * @author Kyle
 */
public class StartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Register register = new Register();
        //Send register the type of input, output strategy, and where the info will be.
        register.startNewSale(new CustomerSelfScanner(), new Receipt(), new FakeDatabaseRetrieval());
    }

}
