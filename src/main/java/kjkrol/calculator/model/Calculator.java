package kjkrol.calculator.model;

import kjkrol.calculator.base.MathBinaryOperation;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

public class Calculator {

    private MathBinaryOperation mathBinaryOperation;
    private BigDecimal firstOperand;

    public void setFirstOperand(BigDecimal operand) {
        firstOperand = operand;
    }

    public void setMathBinaryOperation(MathBinaryOperation mathBinaryOperation) {
        this.mathBinaryOperation = mathBinaryOperation;
    }

    public BigDecimal calculate(BigDecimal secondOperand) {
        if (isReady()) {
            BigDecimal result = mathBinaryOperation.execute(firstOperand, secondOperand);
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

