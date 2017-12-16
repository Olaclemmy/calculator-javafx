package kjkrol.calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
import static kjkrol.calculator.model.NumPadScribe.DoubleParser.parse;

public class NumPadScribe {
    private boolean fractionalPartStarted;
    private boolean negative;
    private final StringBuilder integerPart = new StringBuilder().append(0);
    private final StringBuilder fractionalPart = new StringBuilder();

    public void overwrite(double number) {
        reset();
        parse(this, number);
    }

    public void writeSymbol(char symbol) {
        if (fractionalPartStarted) {
            fractionalPart.append(symbol);
            return;
        }
        if(checkFirstElementOfIntegerPart()) {
            integerPart.setCharAt(0, symbol);
        } else {
            integerPart.append(symbol);
        }
    }

    public void invertSign() {
        negative = !negative;
    }

    public void startFractionalPart() {
        fractionalPartStarted = true;
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        if (negative) {
            result.append('-');
        }
        result.append(integerPart);
        if (fractionalPart.length() > 0) {
            result.append(".");
            result.append(fractionalPart);
        }
        return result.toString();
    }

    public void reset() {
        fractionalPartStarted = false;
        negative = false;
        integerPart.setLength(0);
        fractionalPart.setLength(0);
        integerPart.append(0);
    }

    private boolean checkFirstElementOfIntegerPart() {
        return integerPart.length() == 1 && integerPart.charAt(0) == '0';
    }

    static class DoubleParser {

        private static final Pattern DIGIT_PATTERN = compile("\\d+");

        static void parse(NumPadScribe scribe, double number) {
            String text = Double.toString(number);
            Matcher matcher = DIGIT_PATTERN.matcher(text);
            while (matcher.find()) {
                String numberPart = matcher.group();
                writeAllDigits(scribe, numberPart);
                scribe.startFractionalPart();
            }
            if (number < 0) {
                scribe.invertSign();
            }
        }

        private static void writeAllDigits(NumPadScribe scribe, String numberPart) {
            char[] array = numberPart.toCharArray();
            if (array.length == 1 && array[0] == '0') {
                return;
            }
            for (char symbol : array) {
                scribe.writeSymbol(symbol);
            }
        }
    }

}

