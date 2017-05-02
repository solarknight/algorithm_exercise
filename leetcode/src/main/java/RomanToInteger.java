/**
 * Created by solarknight on 2017/5/2.
 */
public class RomanToInteger {

  public int romanToInt(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int sum = 0, last = 0, cur = 0;
    for (int i = 0; i < s.length(); i++) {
      cur = convert(s.charAt(i));
      sum += last >= cur ? cur : cur - 2 * last;
      last = cur;
    }
    return sum;
  }

  private int convert(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
    }
    return 0;
  }

  public static void main(String[] args) {
    RomanToInteger demo = new RomanToInteger();
    System.out.println(demo.romanToInt("XCIX"));
  }
}
