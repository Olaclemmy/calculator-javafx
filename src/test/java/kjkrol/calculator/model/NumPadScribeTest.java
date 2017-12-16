package kjkrol.calculator.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumPadScribeTest {

    private final NumPadScribe numPadScribe = new NumPadScribe();

    @Test
    public void overwrite() throws Exception {
        // When:
        numPadScribe.writeSymbol('1');
        numPadScribe.overwrite(3.14);

        // Then:
        assertEquals(numPadScribe.print(), "3.14");
    }

    @Test
    public void writeSymbol() throws Exception {
        // When:
        numPadScribe.writeSymbol('1');

        // Then:
        assertEquals(numPadScribe.print(), "1");
    }

    @Test
    public void invertSign() throws Exception {
        // When:
        numPadScribe.writeSymbol('1');
        numPadScribe.invertSign();

        // Then:
        assertEquals(numPadScribe.print(), "-1");
    }

    @Test
    public void startFractionalPart() throws Exception {
        // When:
        numPadScribe.writeSymbol('1');
        numPadScribe.startFractionalPart();
        numPadScribe.writeSymbol('1');

        // Then:
        assertEquals(numPadScribe.print(), "1.1");
    }

    @Test
    public void reset() throws Exception {
        // When:
        numPadScribe.writeSymbol('1');
        numPadScribe.startFractionalPart();
        numPadScribe.writeSymbol('2');
        numPadScribe.reset();

        // Then:
        assertEquals(numPadScribe.print(), "0");
    }

}