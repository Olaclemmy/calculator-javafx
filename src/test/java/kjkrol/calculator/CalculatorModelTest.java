package kjkrol.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorModelTest {
    @Test
    public void calculate() throws Exception {

        // Given
        StringBuilder output = new StringBuilder();
        CalculatorModel calculatorModel = new CalculatorModel(output::append);
        calculatorModel.insertSymbol("1");
        calculatorModel.insertSymbol("0");
        calculatorModel.selectOperation(CalculatorOperation.ADD);
        calculatorModel.insertSymbol("7");
        output.setLength(0);

        // When
        calculatorModel.calculate();

        // Then
        assertEquals("17.0", output.toString());
    }

}