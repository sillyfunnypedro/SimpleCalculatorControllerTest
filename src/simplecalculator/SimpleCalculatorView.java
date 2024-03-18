package simplecalculator;

/**
 * Represents a simple calculator view. The view is responsible for displaying the state of the
 * calculator to the user.
 *
 * In this case it takes two numbers and the result
 */
public class SimpleCalculatorView implements SimpleCalculatorViewInterface {

  /**
   * gets the welcome message.
   *
   * @return the welcome message.
   */
  public String getWelcomeMessage() {
    return "Welcome to the simple calculator!\n";
  }

  /**
   * gets the message for the result.
   *
   * @param one    the first number
   * @param two    the second number
   * @param result the result
   * @return the message for the result
   */
  @Override
  public String getResultMessage(int one, int two, int result) {
    return "The result of " + one + " + " + two + " is " + result;
  }


}
