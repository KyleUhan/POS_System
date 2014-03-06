
package pos_system;

/**
 *
 * @author Kyle
 */
public interface ValidationStrategy {

    public abstract int validateEntry(int numberToValidate);

    public abstract double validateEntry(double numberToValidate);

    public abstract char validateEntry(char charToValidate);
    
    public abstract String validateEntry(String stringToValidate);

}
