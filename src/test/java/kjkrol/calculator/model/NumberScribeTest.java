package kjkrol.calculator.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class NumberScribeTest {

    private final NumberScribe numberScribe = new NumberScribe();

    @Test
    public void noteDown() {
        //When:
        numberScribe.noteDown(new BigDecimal("305.146"));

        //Then
        assertEquals("305.146", numberScribe.print());

        //And:
        numberScribe.noteDown(new BigDecimal("305"));

        //Then
        assertEquals("305", numberScribe.print());

        //And:
        numberScribe.noteDown(new BigDecimal("305.1"));

        //Then
        assertEquals("305.1", numberScribe.print());
    }

    @Test
    public void writeSymbol() throws Exception {
        // When:
        numberScribe.writeSymbol('1');

        // Then:
        assertEquals("1", numberScribe.print());
    }

    @Test
    public void invertSign() throws Exception {
        // When:
        numberScribe.writeSymbol('1');
        numberScribe.invertSign();

        // Then:
        assertEquals("-1", numberScribe.print());
    }

    @Test
    public void startFractionalPart() throws Exception {
        // When:
        numberScribe.writeSymbol('1');
        numberScribe.startFractionalPart();
        numberScribe.writeSymbol('1');

        // Then:
        assertEquals("1.1", numberScribe.print());
    }

    @Test
    public void reset() throws Exception {
        // When:
        numberScribe.writeSymbol('1');
        numberScribe.startFractionalPart();
        numberScribe.writeSymbol('2');
        numberScribe.reset();

        // Then:
        assertEquals("", numberScribe.print());
    }

}