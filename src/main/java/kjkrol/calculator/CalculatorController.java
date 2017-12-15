package kjkrol.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static kjkrol.calculator.CalculatorOperation.ADD;
import static kjkrol.calculator.CalculatorOperation.MULTIPLY;
import static kjkrol.calculator.CalculatorOperation.SUBTRACT;

public class CalculatorController {

    private final CalculatorModel calculatorModel = new CalculatorModel(this::displayOnOutput);

    @FXML
    private TextField output;

    @FXML
    private void insertSymbol(ActionEvent actionEvent) {
        String value = ((Button) actionEvent.getSource()).getText();
        calculatorModel.insertSymbol(value);
    }

    @FXML
    private void clear(ActionEvent actionEvent) {
        calculatorModel.clear();
    }

    @FXML
    private void add(ActionEvent actionEvent) {
        calculatorModel.selectOperation(ADD);
    }

    @FXML
    private void subtract(ActionEvent actionEvent) {
        calculatorModel.selectOperation(SUBTRACT);
    }

    @FXML
    private void multiply(ActionEvent actionEvent) {
        calculatorModel.selectOperation(MULTIPLY);
    }

    @FXML
    private void divide(ActionEvent actionEvent) {
        System.out.println("CalculatorOperation is not implemented yet");
    }

    @FXML
    private void percentOf(ActionEvent actionEvent) {
        System.out.println("CalculatorOperation is not implemented yet");
    }

    @FXML
    private void calculate(ActionEvent actionEvent) {
        calculatorModel.calculate();
    }

    @FXML
    private void invertSign(ActionEvent actionEvent) {
        calculatorModel.invertSign();
    }

    @FXML
    private void insertFractionalPart(ActionEvent actionEvent) {
        calculatorModel.insertFractionalPart();
    }

    private void displayOnOutput(Double number) {
        output.setText(number.toString());
    }
}
