package kjkrol.calculator.model;

import kjkrol.calculator.base.MathOperation;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Calculator {

    private static final double DEFAULT_VALUE = 0.0;

    private MathOperation mathOperation;
    private Double cachedNumber;

    private final RealNumberBuilder numberBuilder = new RealNumberBuilder();

    public double insertSymbol(String text) {
        numberBuilder.append(text.charAt(0));
        return numberBuilder.build();
    }

    public double invertSign() {
        numberBuilder.invertSign();
        return numberBuilder.build();
    }

    public double insertFractionalPart() {
        numberBuilder.insertFractional();
        return numberBuilder.build();
    }

    public double selectMathOperation(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
        Double param = numberBuilder.build();
        if (isNull(this.cachedNumber)) {
            this.cachedNumber = param;
        }
        numberBuilder.reset();
        return param;
    }

    public double calculate() {
        Double param = numberBuilder.build();
        if (isReady()) {
            cachedNumber = mathOperation.execute(cachedNumber, param);
            numberBuilder.reset();
            mathOperation = null;
            return cachedNumber;
        }
        return param;
    }

    public double clear() {
        numberBuilder.reset();
        mathOperation = null;
        cachedNumber = null;
        return DEFAULT_VALUE;
    }

    private boolean isReady() {
        return nonNull(mathOperation) && nonNull(cachedNumber);
    }

}

