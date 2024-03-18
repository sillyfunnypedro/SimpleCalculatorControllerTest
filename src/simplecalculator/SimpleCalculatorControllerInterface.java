package simplecalculator;

import java.io.IOException;

/**
 * Interface for the controller for the SimpleCalculatorModel game. The controller is responsible for
 * handling user moves by executing them using the model and conveying move outcomes to the user in
 * some form.
 */
public interface SimpleCalculatorControllerInterface {

  void runCalculator() throws IOException;
}

