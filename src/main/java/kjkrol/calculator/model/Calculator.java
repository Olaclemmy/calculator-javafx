package kjkrol.calculator.model;

import kjkrol.calculator.base.CalculatorMathOperation;

import java.util.function.Consumer;

public class Calculator {

    private final ComputationSession session = new ComputationSession();
    private final RealNumberBuilder realNumberBuilder = new RealNumberBuilder();
    private final Consumer<Double> output;

    public Calculator(Consumer<Double> output) {
        this.output = output;
    }

    public void insertSymbol(String text) {
        realNumberBuilder.append(text.charAt(0));
        print(realNumberBuilder.build());
    }

    public void invertSign() {
        realNumberBuilder.invertSign();
        print(realNumberBuilder.build());
    }

    public void calculate() {
        if (session.isReady()) {
            Double param = realNumberBuilder.build();
            realNumberBuilder.reset();
            Double result = session.execute(param);
            print(result);
        }
    }

    public void clear() {
        realNumberBuilder.reset();
        session.reset();
        print(realNumberBuilder.build());
    }

    public void insertFractionalPart() {
        realNumberBuilder.insertFractional();
    }

    public void selectOperation(CalculatorMathOperation calculatorMathOperation) {
        Double param = realNumberBuilder.build();
        session.prepare(param, calculatorMathOperation);
        realNumberBuilder.reset();
    }

    private void print(Double number) {
        output.accept(number);
    }

}

