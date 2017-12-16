package kjkrol.calculator.model;

import org.junit.Test;

import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;
import static kjkrol.calculator.base.MathBinaryOperation.ADD;
import static kjkrol.calculator.base.MathBinaryOperation.MULTIPLY;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void calculate() throws Exception {

        // Given
        calculator.setFirstOperand(10);
        calculator.setMathBinaryOperation(ADD);

        // When
        double result = calculator.calculate(7);

        // Then
        assertEquals(17.0, result, MIN_VALUE);

        // And
        calculator.setFirstOperand(10);
        calculator.setMathBinaryOperation(MULTIPLY);

        // When
        result = calculator.calculate(2);

        // Then
        assertEquals(20, result, MIN_VALUE);
    }

}