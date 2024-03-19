import static org.junit.Assert.assertEquals;
import org.junit.Test;
import simplecalculator.SimpleCalculatorController;
import simplecalculator.SimpleCalculatorModelInterface;
import simplecalculator.SimpleCalculatorViewInterface;

import java.io.StringReader;

public class TestController {

  static private class ModelMock implements SimpleCalculatorModelInterface {
    private final Appendable out;
    private final int uniqueId;

    public ModelMock(Appendable out, int uniqueId) {
      this.out = out;
      this.uniqueId = uniqueId;
    }

    @Override
    public int add(int a, int b) {
      try {
        String message = "in model.add(" + a + ", " + b + ")\n";
        out.append(message);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return uniqueId;
    }
  }

  static private class ViewMock implements SimpleCalculatorViewInterface {
    private final Appendable out;

    public ViewMock(Appendable out) {
      this.out = out;
    }

    @Override
    public String getWelcomeMessage() {
      try {
        out.append("in getWelcomeMessage\n");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return "Welcome to the simple calculator!\n";
    }

    @Override
    public String getResultMessage(int one, int two, int result) {
      try {
        out.append("in getResultMessage\n");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return "___RESULT___(" + result + ")";
    }

    @Override
    public String getFirstPrompt() {
      try {
        out.append("in getFirstPrompt\n");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return "1]";
    }

    @Override
    public String getSecondPrompt() {
      try {
        out.append("in getSecondPrompt\n");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return "2]";
    }
  }

  @Test
  public void testRunCalculator() {
    StringBuilder out = new StringBuilder();
    ModelMock model = new ModelMock(out, 42);
    ViewMock view = new ViewMock(out);
    StringReader input = new StringReader("1\n2\nq\n");

    SimpleCalculatorController controller = new SimpleCalculatorController(input, out, model, view);

    try {
      controller.runCalculator();
      assertEquals("in getWelcomeMessage\n" // this is to see if we are in the right function
          + "Welcome to the simple calculator!\n" //this is the welcome message
          + "in getFirstPrompt\n" // this is to see if we are in the right function
          + "1]in getSecondPrompt\n" // The prompt printed and a message from within second prompt
          + "2]in model.add(1, 2)\n" // the two prompts plus a message from within the model
          + "in getResultMessage\n" // this is to see if we are in the right function
          + "___RESULT___(42)\n"  // add always returns 42 so this is the result message
          + "in getFirstPrompt\n" // this is to see if we are in the right function
          + "1]", out.toString());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


}
