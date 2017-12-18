package kjkrol.calculator.model;

import java.math.BigDecimal;
import java.util.function.BiFunction;

import static java.math.RoundingMode.HALF_UP;

enum MathBinaryOperation {
    ADD(BigDecimal::add),
    SUBTRACT(BigDecimal::subtract),
    MULTIPLY(BigDecimal::multiply),
    DIVIDE((a, b) -> a.divide(b, HALF_UP)),
    PERCENT_OF((a, b) -> a.multiply(b).divide(BigDecimal.valueOf(100), HALF_UP));

    private BiFunction<BigDecimal, BigDecimal, BigDecimal> biFunction;

    MathBinaryOperation(BiFunction<BigDecimal, BigDecimal, BigDecimal> biFunction) {
        this.biFunction = biFunction;
    }

    public BigDecimal execute(BigDecimal a, BigDecimal b) {
        return biFunction.apply(a, b);
    }
}
