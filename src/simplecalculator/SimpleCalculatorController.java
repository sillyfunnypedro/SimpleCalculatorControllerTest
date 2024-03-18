package simplecalculator;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SimpleCalculatorController implements SimpleCalculatorControllerInterface {

  private final Readable in;

  private final Appendable out;
  private final SimpleCalculatorModelInterface model;
  private final SimpleCalculatorViewInterface view;

  /**
   * Constructs a new SimpleCalculatorController.
   *
   * @param in    the input source
   * @param out   the output source
   * @param model the model for the game
   * @param view  the view for the game
   */
  public SimpleCalculatorController(Readable in, Appendable out,
                                    SimpleCalculatorModelInterface model, SimpleCalculatorViewInterface view) {
    this.in = in;
    this.out = out;
    this.model = model;
    this.view = view;
  }

  @Override
  public void runCalculator() throws IOException {
    Scanner scan = new Scanner(in);
    String welcomeMessage = view.getWelcomeMessage();
    try {
      out.append(welcomeMessage);

      while (true) {
        out.append("First Number: ");
        int firstNumber = scan.nextInt();
        out.append("Second Number: ");
        int secondNumber = scan.nextInt();

        int result = model.add(firstNumber, secondNumber);

        String resultMessage = view.getResultMessage(firstNumber, secondNumber, result);
        out.append(resultMessage).append("\n");
      }
    } catch (NoSuchElementException e) {
      return;
    } catch (IOException e) {
      throw new IOException("Error: " + e.getMessage());
    }
  }
}
