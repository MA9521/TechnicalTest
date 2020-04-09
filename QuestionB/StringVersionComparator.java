import static java.lang.Integer.parseInt;
import java.util.regex.Pattern;

public class StringVersionComparator {

  /**
   * Compare 2 version strings with format x{.d}* with x being any int, d can be a different int at each occurrence
   * @param versionA 
   * @param versionB
   * @return >0 if A>b , <0 if A<B , 0 if A=B
   */
  public int compareVersions(String versionA, String versionB) {
    if (versionA == null || versionB == null) // check neither string is null
      throw new IllegalArgumentException();
    String regex = "^\\d+(\\.(\\d)+)*$"; // make sure the strings match the version pattern
    if (!Pattern.matches(regex, versionA) || !Pattern.matches(regex, versionB))
      throw new IllegalArgumentException();

    String[] numbersA = versionA.split("\\."); // split the string at the dots
    String[] numbersB = versionB.split("\\.");

    int difference = parseInt(numbersA[0]) - parseInt(numbersB[0]);
    if (difference != 0) // if the first number is different
      return difference;

    // if we need to go through the dots
    int lengthA = numbersA.length;
    int lengthB = numbersB.length;
    int minimumLength = Math.min(lengthA, lengthB);

    for (int i = 1; i < minimumLength; i++) {
      difference = parseInt(numbersA[i]) - parseInt(numbersB[i]);
      if (difference != 0) // as soon as there is a difference return 
        return difference;
    }

    if (lengthA == lengthB) // same version
      return 0;

    if (lengthA > lengthB)// A has at least one additional ".number"
      return 1+parseInt(numbersA[minimumLength]);

    return -1-parseInt(numbersB[minimumLength]); // B has at least one additional ".number"
  }
}
