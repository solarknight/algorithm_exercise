/**
 * Implement atoi to convert a string to an integer.
 * {@see https://leetcode.com/problems/string-to-integer-atoi/#/description}
 * <p>
 * Created by solarknight on 2017/4/23.
 */
public class Atoi {
  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    char[] c = str.toCharArray();
    int idx = 0, flag = 1;
    long sum = 0;

    while (c[idx] == ' ') {
      idx++;
    }

    if (c[idx] == '-') {
      flag = -1;
      idx++;
    } else if (c[idx] == '+') {
      idx++;
    }

    for (; idx < c.length; idx++) {
      int t = c[idx] - '0';
      if (t < 0 || t > 9) {
        break;
      }
      sum = sum * 10 + t;

      if (sum > Integer.MAX_VALUE) {
        return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
    }

    return (int) sum * flag;
  }

  public static void main(String[] args) {
    System.out.println(new Atoi().myAtoi("+432"));
    System.out.println(new Atoi().myAtoi("519"));
    System.out.println(new Atoi().myAtoi("-329"));
    System.out.println(new Atoi().myAtoi("  -32a"));
    System.out.println(new Atoi().myAtoi("-2147483647"));
    System.out.println(new Atoi().myAtoi("9223372036854775809"));
  }
}
