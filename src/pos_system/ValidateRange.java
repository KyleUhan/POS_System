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

    public ValidateRange(final char minChar, final char maxChar) {
        if (minChar > maxChar) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        } else {
            setMinChar(minChar);
            setMaxChar(maxChar);
        }
    }

    @Override
    public final int validateEntry(final int numberToValidate) {
        if (numberToValidate < getMinInt() || numberToValidate > getMaxInt()) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        } else {
            return numberToValidate;
        }
    }

    @Override
    public final double validateEntry(final double numberToValidate) {
        if (numberToValidate < getMinDouble() || numberToValidate > getMaxDouble()) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        } else {
            return numberToValidate;
        }
    }

    @Override
    public final char validateEntry(final char charToValidate) {
        if (charToValidate < getMinChar() || charToValidate > getMaxChar()) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        } else {
            return charToValidate;
        }
    }

    @Override
    public final String validateEntry(final String stringToValidate) {
        if (stringToValidate.length() < getMinInt() || stringToValidate.length() > getMaxInt()) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        } else {
            return stringToValidate;
        }

    }

    //Getters and Setters
    public final double getMinDouble() {
        return minDouble;
    }

    public final void setMinDouble(final double minDouble) {
        this.minDouble = minDouble;
    }

    public final double getMaxDouble() {
        return maxDouble;
    }

    public final void setMaxDouble(final double maxDouble) {
        this.maxDouble = maxDouble;
    }

    public final int getMinInt() {
        return minInt;
    }

    public final void setMinInt(final int minInt) {
        this.minInt = minInt;
    }

    public final int getMaxInt() {
        return maxInt;
    }

    public final void setMaxInt(final int maxInt) {
        this.maxInt = maxInt;
    }

    public final char getMinChar() {
        return minChar;
    }

    public final void setMinChar(final char minChar) {
        this.minChar = minChar;
    }

    public final char getMaxChar() {
        return maxChar;
    }

    public final void setMaxChar(final char maxChar) {
        this.maxChar = maxChar;
    }
}
