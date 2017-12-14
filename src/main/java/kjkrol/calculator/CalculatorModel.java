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

    void insertSymbol(String text) {
        stringBuilder.append(text);
        print();
    }

    void clear() {
        stringBuilder.setLength(0);
        session.clear();
        print();
    }

    void calculate() {
        if (session.isReady()) {
            Double param = parseDouble(stringBuilder.toString());
            Double result = session.execute(param);
            stringBuilder.setLength(0);
            stringBuilder.append(result);
            print();
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
        print();
    }

    void selectOperation(CalculatorOperation calculatorOperation) {
        Double param = parseDouble(stringBuilder.toString());
        session.prepare(param, calculatorOperation);
        stringBuilder.setLength(0);
    }

    private void print() {
        output.accept(stringBuilder.toString());
    }

}
