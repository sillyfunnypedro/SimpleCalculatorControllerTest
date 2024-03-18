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
        String message = "add(" + a + ", " + b + ")\n";
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
        out.append("getWelcomeMessage()\n");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return "Welcome to the simple calculator!\n";
    }

    @Override
    public String getResultMessage(int one, int two, int result) {
      try {
        out.append("view\n");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return "getResultCalled";
    }
  }

  @Test
  public void testRunCalculator() {
    StringBuilder out = new StringBuilder();
    ModelMock model = new ModelMock(out, 42);
    ViewMock view = new ViewMock(out);
    StringReader input = new StringReader("1\n2\n");

    SimpleCalculatorController controller = new SimpleCalculatorController(input, out, model, view);

    try {
      controller.runCalculator();
      assertEquals("getWelcomeMessage()\n"
          + "Welcome to the simple calculator!\n"
          + "First Number: Second Number: add(1, 2)\n"
          + "view\n"
          + "getResultCalled\n"
          + "First Number: ", out.toString());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }
}
