package simplecalculator;

/**
 * Interface for the view for the SimpleCalculatorModel game. The view is responsible for displaying the
 * state of the game to the user.
 */
public interface SimpleCalculatorViewInterface {

  /**
   * Display welcome message.
   *
   * @return welcome message
   */
  public String getWelcomeMessage();

  /**
   * Display message for number of guesses remaining.
   *
   * @param one    first number
   * @param two    second number
   * @param result result of the operation
   * @return The string of the result message
   */
  public String getResultMessage(int one, int two, int result);


}
