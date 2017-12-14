package kjkrol.calculator;

import java.util.Objects;
import java.util.function.Consumer;

import static java.lang.Double.parseDouble;

class CalculatorModel {

    private final CalculationSession session = new CalculationSession();
    private final StringBuilder stringBuilder = new StringBuilder();
    private final Consumer<String> output;

    CalculatorModel(Consumer<String> output) {
        this.output = output;
    }

    void insertSymbol(String symbol) {
        stringBuilder.append(symbol);
        output.accept(stringBuilder.toString());
    }

    void clear() {
        stringBuilder.setLength(0);
        output.accept(stringBuilder.toString());
        session.clear();
    }

    void calculate() {
        if (session.isReady()) {
            Double param = parseDouble(stringBuilder.toString());
            Double result = session.execute(param);
            stringBuilder.setLength(0);
            session.clear();
            stringBuilder.append(result);
            output.accept(stringBuilder.toString());
        }
    }

    void invertSign() {
        if (Objects.equals(stringBuilder.toString(), "0")) {
            return;
        } else if (stringBuilder.toString().startsWith("-")) {
            stringBuilder.deleteCharAt(0);
        } else {
            stringBuilder.insert(0, "-");
        }
        output.accept(stringBuilder.toString());
    }

    void selectOperation(CalculatorOperation calculatorOperation) {
        Double param = parseDouble(stringBuilder.toString());
        session.prepare(param, calculatorOperation);
        stringBuilder.setLength(0);
    }

}
