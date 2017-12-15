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

    private final Calculator calculator = new Calculator();

    @FXML
    private TextField output;

    @FXML
    private void insertSymbol(ActionEvent actionEvent) {
        String value = ((Button) actionEvent.getSource()).getText();
        double result = calculator.insertSymbol(value);
        refreshOutput(result);
    }

    @FXML
    private void clear(ActionEvent actionEvent) {
        double result = calculator.clear();
        refreshOutput(result);
    }

    @FXML
    private void add(ActionEvent actionEvent) {
        double result = calculator.selectMathOperation(ADD);
        refreshOutput(result);
    }

    @FXML
    private void subtract(ActionEvent actionEvent) {
        double result = calculator.selectMathOperation(SUBTRACT);
        refreshOutput(result);
    }

    @FXML
    private void multiply(ActionEvent actionEvent) {
        double result = calculator.selectMathOperation(MULTIPLY);
        refreshOutput(result);
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
        double result = calculator.calculate();
        refreshOutput(result);
    }

    @FXML
    private void invertSign(ActionEvent actionEvent) {
        double result = calculator.invertSign();
        refreshOutput(result);
    }

    @FXML
    private void insertFractionalPart(ActionEvent actionEvent) {
        double result = calculator.insertFractionalPart();
        refreshOutput(result);
    }

    private void refreshOutput(Double number) {
        output.setText(number.toString());
    }
}
