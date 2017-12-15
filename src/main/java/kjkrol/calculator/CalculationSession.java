package kjkrol.calculator;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

class CalculationSession {
    private CalculatorOperation calculatorOperation;
    private Double firstParam;

    void prepare(Double firstParam, CalculatorOperation calculatorOperation) {
        this.calculatorOperation = calculatorOperation;
        if (isNull(this.firstParam)) {
            this.firstParam = firstParam;
        }
    }

    boolean isReady() {
        return nonNull(calculatorOperation) && nonNull(firstParam);
    }

    Double execute(Double secondParam) {
        Double result = calculatorOperation.execute(firstParam, secondParam);
        calculatorOperation = null;
        firstParam = result;
        return result;
    }

    void reset() {
        calculatorOperation = null;
        firstParam = null;
    }
}
