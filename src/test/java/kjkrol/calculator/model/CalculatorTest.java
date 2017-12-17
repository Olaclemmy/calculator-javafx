package kjkrol.calculator.model;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static kjkrol.calculator.base.MathBinaryOperation.ADD;
import static kjkrol.calculator.base.MathBinaryOperation.MULTIPLY;
import static kjkrol.calculator.base.MathBinaryOperation.SUBTRACT;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void calculate() throws Exception {

        // Given
        calculator.setFirstOperand(valueOf(10));
        calculator.setMathBinaryOperation(ADD);

        // When
        BigDecimal result = calculator.calculate(valueOf(7));

        // Then
        assertEquals(valueOf(17), result);

        // And
        calculator.setFirstOperand(valueOf(10));
        calculator.setMathBinaryOperation(MULTIPLY);

        // When
        result = calculator.calculate(valueOf(2));

        // Then
        assertEquals(valueOf(20), result);

        // Given
        calculator.setFirstOperand(valueOf(6.1));
        calculator.setMathBinaryOperation(SUBTRACT);

        // When
        result = calculator.calculate(valueOf(6));

        // Then
        assertEquals(valueOf(0.1), result);
    }

}