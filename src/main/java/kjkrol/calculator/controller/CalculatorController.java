package kjkrol.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kjkrol.calculator.base.MathBinaryOperation;
import kjkrol.calculator.model.Calculator;
import kjkrol.calculator.model.NumPadScribe;

import java.math.BigDecimal;

import static kjkrol.calculator.base.MathBinaryOperation.ADD;
import static kjkrol.calculator.base.MathBinaryOperation.DIVIDE;
import static kjkrol.calculator.base.MathBinaryOperation.MULTIPLY;
import static kjkrol.calculator.base.MathBinaryOperation.PERCENT_OF;
import static kjkrol.calculator.base.MathBinaryOperation.SUBTRACT;

public class CalculatorController {

    private final Calculator calculator = new Calculator();
    private final NumPadScribe numPadScribe = new NumPadScribe();

    @FXML
    private TextField output;

    @FXML
    private void writeSymbol(ActionEvent actionEvent) {
        char symbol = ((Button) actionEvent.getSource()).getText().charAt(0);
        numPadScribe.writeSymbol(symbol);
        refreshDisplay();
    }

    @FXML
    private void invertSign() {
        numPadScribe.invertSign();
        refreshDisplay();
    }

    @FXML
    private void startFractionalPart() {
        numPadScribe.startFractionalPart();
    }

    @FXML
    private void add() {
        selectMathBinaryOperation(ADD);
    }

    @FXML
    private void subtract() {
        selectMathBinaryOperation(SUBTRACT);
    }

    @FXML
    private void multiply() {
        selectMathBinaryOperation(MULTIPLY);
    }

    @FXML
    private void divide() {
        selectMathBinaryOperation(DIVIDE);
    }

    @FXML
    private void percentOf() {
        selectMathBinaryOperation(PERCENT_OF);
    }

    @FXML
    private void clear() {
        numPadScribe.reset();
        calculator.reset();
        refreshDisplay();
    }

    @FXML
    private void calculate() {
        String displayedNumber = numPadScribe.print();
        BigDecimal operand = new BigDecimal(displayedNumber);
        try {
            BigDecimal result = calculator.calculate(operand);
            numPadScribe.overwrite(result);
            refreshDisplay();
        } catch (ArithmeticException e) {
            clear();
            output.setText("NAN");
        }
    }

    private void selectMathBinaryOperation(MathBinaryOperation mathBinaryOperation) {
        String displayedNumber = numPadScribe.print();
        BigDecimal operand = new BigDecimal(displayedNumber);
        calculator.setFirstOperand(operand);
        calculator.setMathBinaryOperation(mathBinaryOperation);
        numPadScribe.reset();
    }

    private void refreshDisplay() {
        String displayedNumber = numPadScribe.print();
        output.setText(displayedNumber);
    }
}
