import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class LineComparatorTest {

  @Test
  public void testIllegalArguments() {
    LineComparator lineComparator = new LineComparator();

    ArrayList<Double> validList = new ArrayList<Double>(Arrays.asList(2.5, 1.5));
    ArrayList<Double> wrongSizeList = new ArrayList<Double>(Arrays.asList(2.5, 1.5, 4.0));
    ArrayList<Double> wrongElementList = new ArrayList<Double>(Arrays.asList(2.5, null));

    assertThrows(IllegalArgumentException.class, () -> {
      lineComparator.areOverlapped(null, validList);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      lineComparator.areOverlapped(validList, wrongSizeList);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      lineComparator.areOverlapped(wrongElementList, validList);
    });
  }

  @Test
  public void testValidLines() {
    LineComparator lineComparator = new LineComparator();

    ArrayList<Double> line1 = new ArrayList<Double>(Arrays.asList(2.5, 1.5));
    ArrayList<Double> line2 = new ArrayList<Double>(Arrays.asList(3.0, 4.0));
    ArrayList<Double> line3 = new ArrayList<Double>(Arrays.asList(3.25, 3.75));
    ArrayList<Double> line4 = new ArrayList<Double>(Arrays.asList(1.0, 2.0));
    
    assertFalse(lineComparator.areOverlapped(line1, line2));
    assertFalse(lineComparator.areOverlapped(line1, line2));
    assertTrue(lineComparator.areOverlapped(line2, line3));
    assertTrue(lineComparator.areOverlapped(line4, line1));
  }
}
