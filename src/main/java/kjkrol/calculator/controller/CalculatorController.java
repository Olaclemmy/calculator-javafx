package kjkrol.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kjkrol.calculator.model.Calculator;

import static kjkrol.calculator.base.MathOperation.ADD;
import static kjkrol.calculator.base.MathOperation.MULTIPLY;
import static kjkrol.calculator.base.MathOperation.SUBTRACT;

public class CalculatorController {

    private final Calculator calculator = new Calculator(this::displayOnOutput);

    @FXML
    private TextField output;

    @FXML
    private void insertSymbol(ActionEvent actionEvent) {
        String value = ((Button) actionEvent.getSource()).getText();
        calculator.insertSymbol(value);
    }

    @FXML
    private void clear(ActionEvent actionEvent) {
        calculator.clear();
    }

    @FXML
    private void add(ActionEvent actionEvent) {
        calculator.selectOperation(ADD);
    }

    @FXML
    private void subtract(ActionEvent actionEvent) {
        calculator.selectOperation(SUBTRACT);
    }

    @FXML
    private void multiply(ActionEvent actionEvent) {
        calculator.selectOperation(MULTIPLY);
    }

    @FXML
    private void divide(ActionEvent actionEvent) {
        System.out.println("MathOperation is not implemented yet");
    }

    @FXML
    private void percentOf(ActionEvent actionEvent) {
        System.out.println("MathOperation is not implemented yet");
    }

    @FXML
    private void calculate(ActionEvent actionEvent) {
        calculator.calculate();
    }

    @FXML
    private void invertSign(ActionEvent actionEvent) {
        calculator.invertSign();
    }

    @FXML
    private void insertFractionalPart(ActionEvent actionEvent) {
        calculator.insertFractionalPart();
    }

    private void displayOnOutput(Double number) {
        output.setText(number.toString());
    }
}
