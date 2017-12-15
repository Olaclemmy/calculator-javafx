package kjkrol.calculator;

import kjkrol.calculator.base.CalculatorMathOperation;
import kjkrol.calculator.model.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void calculate() throws Exception {

        // Given
        StringBuilder output = new StringBuilder();
        Calculator calculator = new Calculator(output::append);
        calculator.insertSymbol("1");
        calculator.insertSymbol("0");
        calculator.selectOperation(CalculatorMathOperation.ADD);
        calculator.insertSymbol("7");
        output.setLength(0);

        // When
        calculator.calculate();

        // Then
        assertEquals("17.0", output.toString());
    }

}