package kjkrol.calculator;

import kjkrol.calculator.base.MathOperation;
import kjkrol.calculator.model.Calculator;
import org.junit.Test;

import static java.lang.Double.MIN_VALUE;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void calculate() throws Exception {

        // Given
        Calculator calculator = new Calculator();
        calculator.insertSymbol("1");
        calculator.insertSymbol("0");
        calculator.selectMathOperation(MathOperation.ADD);
        calculator.insertSymbol("7");

        // When
        double result = calculator.calculate();

        // Then
        assertEquals(17.0, result, MIN_VALUE);

        // And
        calculator.selectMathOperation(MathOperation.MULTIPLY);
        calculator.insertSymbol("2");

        // When
        result = calculator.calculate();

        // Then
        assertEquals(34.0, result, MIN_VALUE);
    }

}