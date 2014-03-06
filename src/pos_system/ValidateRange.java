
package pos_system;

/**
 *
 * @author Kyle
 */
public class ValidateRange implements ValidationStrategy {

    private static final String FORMAT_ERROR = "Error - Format: Min,Max";
    private static final String OUT_OF_RANGE = "Value it out of allowed range";
    private double minDouble;
    private double maxDouble;

    private int minInt;
    private int maxInt;

    private char minChar;
    private char maxChar;

    public ValidateRange(final int minInt, final int maxInt) {
        if (minInt > maxInt) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        } else {
            setMinInt(minInt);
            setMaxInt(maxInt);
        }

    }

    public ValidateRange(final double minDouble, final double maxDouble) {
        if (minDouble > maxDouble) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        } else {
            setMinDouble(minDouble);
            setMaxDouble(maxDouble);
        }
    }

    public ValidateRange(char minChar, char maxChar) {
        if (minChar > maxChar) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        } else {
            setMinChar(minChar);
            setMaxChar(maxChar);
        }
    }

    public int validateEntry(int numberToValidate) {
        if (numberToValidate < getMinInt() || numberToValidate > getMaxInt()) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        } else {
            return numberToValidate;
        }
    }

    public double validateEntry(double numberToValidate) {
        if (numberToValidate < getMinDouble() || numberToValidate > getMaxDouble()) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        } else {
            return numberToValidate;
        }
    }

    public char validateEntry(char charToValidate) {
        if (charToValidate < getMinChar() || charToValidate > getMaxChar()) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        } else {
            return charToValidate;
        }
    }
    
    public final String validateEntry(String stringToValidate){
        //working on string validation types
        return stringToValidate;
    }

    public double getMinDouble() {
        return minDouble;
    }

    public void setMinDouble(double minDouble) {
        this.minDouble = minDouble;
    }

    public double getMaxDouble() {
        return maxDouble;
    }

    public void setMaxDouble(double maxDouble) {
        this.maxDouble = maxDouble;
    }

    public int getMinInt() {
        return minInt;
    }

    public void setMinInt(int minInt) {
        this.minInt = minInt;
    }

    public int getMaxInt() {
        return maxInt;
    }

    public void setMaxInt(int maxInt) {
        this.maxInt = maxInt;
    }

    public char getMinChar() {
        return minChar;
    }

    public void setMinChar(char minChar) {
        this.minChar = minChar;
    }

    public char getMaxChar() {
        return maxChar;
    }

    public void setMaxChar(char maxChar) {
        this.maxChar = maxChar;
    }

    public static void main(String[] args) {
        ValidationStrategy vs;
        vs = new ValidateRange(1,10);
        vs.validateEntry(7);
        System.out.println("build 1 successful");
        vs.validateEntry(12);

    }

}
