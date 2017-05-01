/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * {@see https://leetcode.com/problems/integer-to-roman/#/description}
 * <p>
 * Created by solarknight on 2017/5/1.
 */
public class IntegerToRoman {
  private static final String[] M = {"", "M", "MM", "MMM"};
  private static final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
  private static final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
  private static final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

  public String intToRoman(int num) {
    if (num < 10) {
      return I[num];
    } else if (num < 100) {
      return X[num / 10] + I[num % 10];
    } else if (num < 1000) {
      return C[num / 100] + X[(num % 100) / 10] + I[num % 10];
    } else {
      return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
  }

  public static void main(String[] args) {
    IntegerToRoman demo = new IntegerToRoman();
    System.out.println(demo.intToRoman(99));
  }
}
