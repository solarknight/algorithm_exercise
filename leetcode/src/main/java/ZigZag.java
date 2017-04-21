/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * Created by solarknight on 2017/4/20.
 */
public class ZigZag {

  public String convert(String s, int numRows) {
    if (s.length() <= 1 || numRows <= 1) {
      return s;
    }

    StringBuilder[] sb = new StringBuilder[numRows];
    for (int i = 0; i < sb.length; i++) {
      sb[i] = new StringBuilder();
    }

    int incr = 0;
    for (int i = 0, j = 0; j < s.length(); j++) {
      if (i == 0) {
        incr = 1;
      }
      if (i == numRows - 1) {
        incr = -1;
      }
      sb[i].append(s.charAt(j));
      i += incr;
    }

    for (int i = 1; i < sb.length; i++) {
      sb[0].append(sb[i]);
    }
    return sb[0].toString();
  }

  public static void main(String[] args) {
    System.out.println(new ZigZag().convert("PAYPALISHIRING", 3));
  }
}
