import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class StringVersionComparatorTest {
  @Test
  public void testIllegalArguments() {
    StringVersionComparator comp = new StringVersionComparator();

    assertThrows(IllegalArgumentException.class, () -> {
      comp.compareVersions(null, "1.2");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      comp.compareVersions("1.2", ".3");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      comp.compareVersions("3.4", "1.2.");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      comp.compareVersions("1.2", "1..2");
    });
  }

  @Test
  public void testLegalArguments() {
    StringVersionComparator comp = new StringVersionComparator();

    assertEquals(-1, comp.compareVersions("2", "3"));
    assertEquals(1, comp.compareVersions("3", "2"));
    assertEquals(1, comp.compareVersions("3", "2.999999"));
    
    assertEquals(0, comp.compareVersions("23.4.1", "23.4.1"));
    assertEquals(-1, comp.compareVersions("23.3.1", "23.4.1"));
    assertEquals(2, comp.compareVersions("25.4.1", "23.4.1"));
    assertEquals(-4, comp.compareVersions("23.4.1", "23.4.5"));
    
    assertEquals(1, comp.compareVersions("23.4.4.0", "23.4.4"));
    assertEquals(-7, comp.compareVersions("23.4.4", "23.4.4.6"));
  }
}
