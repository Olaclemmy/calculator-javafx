package kjkrol.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Objects;
import java.util.function.BiFunction;

import static java.lang.Double.parseDouble;

public class Controller {

    private final static BiFunction<Double, Double, Double> ADD = (a, b) -> a + b;
    private final static BiFunction<Double, Double, Double> SUBTRACT = (a, b) -> a - b;
    private final static BiFunction<Double, Double, Double> MULTIPLY = (a, b) -> a * b;

    @FXML
    private Text output;

    private final CalculationSession session = new CalculationSession();

    private final StringBuilder stringBuilder = new StringBuilder();

    @FXML
    private void insertSymbol(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        stringBuilder.append(value);
        output.setText(stringBuilder.toString());
    }

    @FXML
    private void clear(ActionEvent actionEvent) {
        stringBuilder.setLength(0);
        output.setText(stringBuilder.toString());
        session.clear();
    }

    @FXML
    private void add(ActionEvent actionEvent) {
        selectOperation(ADD);
    }

    @FXML
    private void subtract(ActionEvent actionEvent) {
        selectOperation(SUBTRACT);
    }

    @FXML
    private void multiply(ActionEvent actionEvent) {
        selectOperation(MULTIPLY);
    }

    @FXML
    private void divide(ActionEvent actionEvent) {
        System.out.println("Operation is not implemented yet");
    }

    @FXML
    private void percentOf(ActionEvent actionEvent) {
        System.out.println("Operation is not implemented yet");
    }

    @FXML
    private void calculate(ActionEvent event) {
        if (session.isReady()) {
            Double param = parseDouble(stringBuilder.toString());
            Double result = session.execute(param);
            output.setText(result.toString());
            session.clear();
        }
    }

    @FXML
    private void invertSign(ActionEvent actionEvent) {
        if (Objects.equals(stringBuilder.toString(), "0")) {
            return;
        } else if (stringBuilder.toString().startsWith("-")) {
            stringBuilder.deleteCharAt(0);
        } else {
            stringBuilder.insert(0, "-");
        }
        output.setText(stringBuilder.toString());
    }

    private void selectOperation(BiFunction<Double, Double, Double> biFunction) {
        Double param = parseDouble(stringBuilder.toString());
        session.prepare(param, biFunction);
        stringBuilder.setLength(0);
    }
}
