package kjkrol.calculator.model;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

public class Calculator {

    private MathBinaryOperation mathBinaryOperation;
    private BigDecimal firstOperand;

    public void setFirstOperand(BigDecimal operand) {
        firstOperand = operand;
    }

    public void setMathBinaryOperation(String mathBinaryOperationName) {
        mathBinaryOperation = MathBinaryOperation.valueOf(mathBinaryOperationName);
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

