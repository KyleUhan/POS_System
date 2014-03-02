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
        register.startNewSale(new CustomerSelfScanner());
    }

}
