package kjkrol.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kjkrol.calculator.model.Calculator;
import kjkrol.calculator.model.NumberScribe;

import java.math.BigDecimal;

public class CalculatorController {

    private final Calculator calculator = new Calculator();
    private final NumberScribe numberScribe = new NumberScribe();

    @FXML
    private TextField outputDisplay;

    @FXML
    private void writeSymbol(ActionEvent actionEvent) {
        char symbol = ((Button) actionEvent.getSource()).getText().charAt(0);
        numberScribe.writeSymbol(symbol);
        printScribedNumberOnDisplay();
    }

    @FXML
    private void invertSign() {
        numberScribe.invertSign();
        printScribedNumberOnDisplay();
    }

    @FXML
    private void startFractionalPart() {
        numberScribe.startFractionalPart();
    }

    @FXML
    private void clear() {
        numberScribe.reset();
        calculator.reset();
        printScribedNumberOnDisplay();
    }

    @FXML
    private void selectMathBinaryOperation(ActionEvent actionEvent) {
        BigDecimal operand = readNumberFromOutputDisplay();
        String mathBinaryOperationName = ((Button) actionEvent.getSource()).getId();
        calculator.setFirstOperand(operand);
        calculator.setMathBinaryOperation(mathBinaryOperationName);
        numberScribe.reset();
    }

    @FXML
    private void calculate() {
        String displayedNumber = numberScribe.print();
        BigDecimal operand = new BigDecimal(displayedNumber);
        try {
            BigDecimal result = calculator.calculate(operand);
            numberScribe.noteDown(result);
            printScribedNumberOnDisplay();
        } catch (ArithmeticException ex) {
            clear();
            outputDisplay.setText("NAN");
        }
    }

    private BigDecimal readNumberFromOutputDisplay() {
        try {
            return new BigDecimal(outputDisplay.getText());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    private void printScribedNumberOnDisplay() {
        String displayedNumber = numberScribe.print();
        outputDisplay.setText(displayedNumber);
    }
}
