package kjkrol.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kjkrol.calculator.base.MathBinaryOperation;
import kjkrol.calculator.model.Calculator;
import kjkrol.calculator.model.NumPadScribe;

import static java.lang.Double.parseDouble;
import static kjkrol.calculator.base.MathBinaryOperation.ADD;
import static kjkrol.calculator.base.MathBinaryOperation.MULTIPLY;
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
    private void invertSign(ActionEvent actionEvent) {
        numPadScribe.invertSign();
        refreshDisplay();
    }

    @FXML
    private void startFractionalPart(ActionEvent actionEvent) {
        numPadScribe.startFractionalPart();
    }

    @FXML
    private void add(ActionEvent actionEvent) {
        selectMathBinaryOperation(ADD);
    }

    @FXML
    private void subtract(ActionEvent actionEvent) {
        selectMathBinaryOperation(SUBTRACT);
    }

    @FXML
    private void multiply(ActionEvent actionEvent) {
        selectMathBinaryOperation(MULTIPLY);
    }

    @FXML
    private void divide(ActionEvent actionEvent) {
        System.out.println("MathBinaryOperation is not implemented yet");
    }

    @FXML
    private void percentOf(ActionEvent actionEvent) {
        System.out.println("MathBinaryOperation is not implemented yet");
    }

    @FXML
    private void clear(ActionEvent actionEvent) {
        numPadScribe.reset();
        calculator.reset();
        refreshDisplay();
    }

    @FXML
    private void calculate(ActionEvent actionEvent) {
        String displayedNumber = numPadScribe.print();
        double operand = parseDouble(displayedNumber);
        double result = calculator.calculate(operand);
        numPadScribe.overwrite(result);
        refreshDisplay();
    }

    private void selectMathBinaryOperation(MathBinaryOperation mathBinaryOperation) {
        String displayedNumber = numPadScribe.print();
        double operand = parseDouble(displayedNumber);
        calculator.setFirstOperand(operand);
        calculator.setMathBinaryOperation(mathBinaryOperation);
        numPadScribe.reset();
    }

    private void refreshDisplay() {
        String displayedNumber = numPadScribe.print();
        output.setText(displayedNumber);
    }
}
