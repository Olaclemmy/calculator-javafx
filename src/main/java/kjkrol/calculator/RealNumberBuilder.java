package kjkrol.calculator;

import static java.lang.Double.parseDouble;

class RealNumberBuilder {
    private boolean sign = true;
    private boolean insertingInteger = true;
    private final StringBuilder integerPart = new StringBuilder();
    private final StringBuilder fractionalPart = new StringBuilder();

    Double build() {
        return parseDouble(getSign() + getIntegerPart() + "." + getFractionalPart());
    }

    void invertSign() {
        sign = !sign;
    }

    void insertFractional() {
        insertingInteger = false;
    }

    void append(char symbol) {
        if (insertingInteger) {
            appendIntegerPart(symbol);
        } else {
            appendFractionalPart(symbol);
        }
    }

    void reset() {
        insertingInteger = true;
        sign = true;
        integerPart.setLength(0);
        fractionalPart.setLength(0);
    }

    private void appendIntegerPart(char symbol) {
        integerPart.append(symbol);
    }

    private void appendFractionalPart(char symbol) {
        fractionalPart.append(symbol);
    }

    private String getIntegerPart() {
        return integerPart.length() == 0 ? "0" : integerPart.toString();
    }

    private String getFractionalPart() {
        return fractionalPart.length() == 0 ? "0" : fractionalPart.toString();
    }

    private String getSign() {
        return sign ? "" : "-";
    }
}
