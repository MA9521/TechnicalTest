import java.util.Collections;
import java.util.List;

public class LineComparator {

  /**
   * Check if 2 lines overlap
   * @param line1 a list of 2 Doubles
   * @param line2 a list of 2 Doubles
   * @return true if lines overlap false if not
   */
  public boolean areOverlapped(List<Double> line1, List<Double> line2) {
    //error handling
    if (line1 == null || line2 == null)
      throw new IllegalArgumentException();
    if (line1.size() != 2 || line2.size() != 2 || line1.contains(null) || line2.contains(null))
      throw new IllegalArgumentException();

    Collections.sort(line1); //sort the points
    Collections.sort(line2);
    double startLine1 = line1.get(0);
    double endLine1 = line1.get(1);
    double startLine2 = line2.get(0);
    double endLine2 = line2.get(1);

    if ((startLine1 >= startLine2 && startLine1 <= endLine2)
        || (startLine2 >= startLine1 && startLine2 <= endLine1))
      return true;

    return false;
  }
}
