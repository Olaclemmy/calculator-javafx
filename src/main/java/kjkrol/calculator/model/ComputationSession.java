package kjkrol.calculator.model;

import kjkrol.calculator.base.MathOperation;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

class ComputationSession {
    private MathOperation mathOperation;
    private Double firstParam;

    void prepare(Double firstParam, MathOperation mathOperation) {
        this.mathOperation = mathOperation;
        if (isNull(this.firstParam)) {
            this.firstParam = firstParam;
        }
    }

    boolean isReady() {
        return nonNull(mathOperation) && nonNull(firstParam);
    }

    Double execute(Double secondParam) {
        Double result = mathOperation.execute(firstParam, secondParam);
        mathOperation = null;
        firstParam = result;
        return result;
    }

    void reset() {
        mathOperation = null;
        firstParam = null;
    }
}
