package kjkrol.calculator;

import java.util.function.BiFunction;

enum CalculatorOperation {
    ADD((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b);

    private BiFunction<Double, Double, Double> biFunction;

    CalculatorOperation(BiFunction<Double, Double, Double> biFunction) {
        this.biFunction = biFunction;
    }

    Double execute(Double a, Double b) {
        return biFunction.apply(a, b);
    }
}
