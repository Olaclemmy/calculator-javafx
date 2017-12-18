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
    private TextField output;

    @FXML
    private void writeSymbol(ActionEvent actionEvent) {
        char symbol = ((Button) actionEvent.getSource()).getText().charAt(0);
        numberScribe.writeSymbol(symbol);
        refreshDisplay();
    }

    @FXML
    private void invertSign() {
        numberScribe.invertSign();
        refreshDisplay();
    }

    @FXML
    private void startFractionalPart() {
        numberScribe.startFractionalPart();
    }

    @FXML
    private void clear() {
        numberScribe.reset();
        calculator.reset();
        refreshDisplay();
    }

    @FXML
    private void selectMathBinaryOperation(ActionEvent actionEvent) {
        BigDecimal operand;
        try {
            operand = new BigDecimal(output.getText());

        } catch (NumberFormatException ex) {
            operand = BigDecimal.ZERO;
        }
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
            refreshDisplay();
        } catch (ArithmeticException ex) {
            clear();
            output.setText("NAN");
        }
    }

    private void refreshDisplay() {
        String displayedNumber = numberScribe.print();
        output.setText(displayedNumber);
    }
}
