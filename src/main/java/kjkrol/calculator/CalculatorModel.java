package kjkrol.calculator;

import java.util.function.Consumer;

class CalculatorModel {

    private final CalculationSession session = new CalculationSession();
    private final RealNumberBuilder realNumberBuilder = new RealNumberBuilder();
    private final Consumer<Double> output;

    CalculatorModel(Consumer<Double> output) {
        this.output = output;
    }

    void insertSymbol(String text) {
        realNumberBuilder.append(text.charAt(0));
        print(realNumberBuilder.build());
    }

    void clear() {
        realNumberBuilder.reset();
        session.reset();
        print(realNumberBuilder.build());
    }

    void calculate() {
        if (session.isReady()) {
            Double param = realNumberBuilder.build();
            realNumberBuilder.reset();
            Double result = session.execute(param);
            print(result);
        }
    }

    void insertFractionalPart() {
        realNumberBuilder.insertFractional();
    }

    void invertSign() {
        realNumberBuilder.invertSign();
        print(realNumberBuilder.build());
    }

    void selectOperation(CalculatorOperation calculatorOperation) {
        Double param = realNumberBuilder.build();
        session.prepare(param, calculatorOperation);
        realNumberBuilder.reset();
    }

    private void print(Double number) {
        output.accept(number);
    }

}

