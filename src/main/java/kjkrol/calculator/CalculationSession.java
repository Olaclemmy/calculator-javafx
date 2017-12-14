package kjkrol.calculator;

import java.util.function.BiFunction;

import static java.util.Objects.nonNull;

class CalculationSession {
    private BiFunction<Double, Double, Double> selectedOperation;
    private Double firstParam;

    void prepare(Double firstParam, BiFunction<Double, Double, Double> selectedOperation) {
        this.selectedOperation = selectedOperation;
        this.firstParam = firstParam;
    }

    boolean isReady() {
        return nonNull(selectedOperation) && nonNull(firstParam);
    }

    Double execute(Double secondParam) {
        return selectedOperation.apply(firstParam, secondParam);
    }

    void clear() {
        selectedOperation = null;
        firstParam = null;
    }
}
