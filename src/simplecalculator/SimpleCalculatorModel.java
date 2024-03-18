package simplecalculator;

/**
 * Represents a simple calculator that can add two integers.
 */
public class SimpleCalculatorModel implements SimpleCalculatorModelInterface {

  /**
   * The add method takes two integers and returns their sum.
   * @param a the first parameter.
   * @param b the second parameter.
   * @return the sum of a and b.
   */
  @Override
  public int add(int a, int b) {
    return a + b;
  }
}
