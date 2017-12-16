package kjkrol.calculator.model;

import kjkrol.calculator.base.MathBinaryOperation;

import static java.util.Objects.nonNull;

public class Calculator {

    private MathBinaryOperation mathBinaryOperation;
    private Double firstOperand;

    public void setFirstOperand(double operand) {
        firstOperand = operand;
    }

    public void setMathBinaryOperation(MathBinaryOperation mathBinaryOperation) {
        this.mathBinaryOperation = mathBinaryOperation;
    }

    public double calculate(double secondOperand) {
        if (isReady()) {
            double result = mathBinaryOperation.execute(firstOperand, secondOperand);
            reset();
            return result;
        }
        return secondOperand;
    }

    public void reset() {
        mathBinaryOperation = null;
        firstOperand = null;
    }

    private boolean isReady() {
        return nonNull(mathBinaryOperation) && nonNull(firstOperand);
    }

}

