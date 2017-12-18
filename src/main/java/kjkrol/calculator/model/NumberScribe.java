package kjkrol.calculator.model;

import java.math.BigDecimal;

public class NumberScribe {
    private boolean negative;
    private final StringBuilder integerPart = new StringBuilder();
    private final StringBuilder fractionalPart = new StringBuilder();

    public void writeSymbol(char symbol) {
        if (fractionalPart.length() > 0) {
            fractionalPart.append(symbol);
            return;
        }
        if (preventToInsertMultipleLeadingZeros()) {
            integerPart.setCharAt(0, symbol);
        } else {
            integerPart.append(symbol);
        }
    }

    public void invertSign() {
        negative = !negative;
    }

    public void startFractionalPart() {
        if (fractionalPart.length() < 1) {
            fractionalPart.append('.');
        }
    }

    public void noteDown(BigDecimal number) {
        reset();
        String text = number.abs().toPlainString();
        int delimiterPosition = text.indexOf('.');
        if (delimiterPosition > 0) {
            integerPart.append(text.substring(0, delimiterPosition));
            startFractionalPart();
            fractionalPart.append(text.substring(delimiterPosition + 1, text.length()));
        } else {
            integerPart.append(text);
        }
        if (number.signum() < 0) {
            invertSign();
        }
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        if (negative) {
            result.append('-');
        }
        result.append(integerPart);
        if (fractionalPart.length() > 0) {
            result.append(fractionalPart);
        }
        return result.toString();
    }

    public void reset() {
        negative = false;
        integerPart.setLength(0);
        fractionalPart.setLength(0);
    }

    private boolean preventToInsertMultipleLeadingZeros() {
        return integerPart.length() == 1 && integerPart.charAt(0) == '0';
    }

}

