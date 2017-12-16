package kjkrol.calculator.base;

import java.util.function.BiFunction;

public enum MathBinaryOperation {
    ADD((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b);

    private BiFunction<Double, Double, Double> biFunction;

    MathBinaryOperation(BiFunction<Double, Double, Double> biFunction) {
        this.biFunction = biFunction;
    }

    public Double execute(Double a, Double b) {
        return biFunction.apply(a, b);
    }
}
