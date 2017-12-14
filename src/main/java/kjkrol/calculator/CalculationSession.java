package kjkrol.calculator;

import static java.util.Objects.nonNull;

class CalculationSession {
    private CalculatorOperation calculatorOperation;
    private Double firstParam;

    void prepare(Double firstParam, CalculatorOperation calculatorOperation) {
        this.calculatorOperation = calculatorOperation;
        this.firstParam = firstParam;
    }

    boolean isReady() {
        return nonNull(calculatorOperation) && nonNull(firstParam);
    }

    Double execute(Double secondParam) {
        Double result = calculatorOperation.execute(firstParam, secondParam);
        firstParam = result;
        calculatorOperation = null;
        return result;
    }

    void clear() {
        calculatorOperation = null;
        firstParam = null;
    }
}
