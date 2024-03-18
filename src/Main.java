import simplecalculator.SimpleCalculatorViewInterface;
import simplecalculator.SimpleCalculatorView;
import simplecalculator.SimpleCalculatorModelInterface;
import simplecalculator.SimpleCalculatorModel;
import simplecalculator.SimpleCalculatorControllerInterface;
import simplecalculator.SimpleCalculatorController;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    SimpleCalculatorViewInterface view = new SimpleCalculatorView();
    SimpleCalculatorModelInterface model = new SimpleCalculatorModel();
    Reader reader = new InputStreamReader(System.in);
    SimpleCalculatorControllerInterface controller =
        new SimpleCalculatorController(reader, System.out, model, view);
    try {
      controller.runCalculator();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

  }
}
