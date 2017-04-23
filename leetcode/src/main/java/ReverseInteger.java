/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * {@see https://leetcode.com/problems/reverse-integer/#/description}
 * Created by solarknight on 2017/4/23.
 */
public class ReverseInteger {

  public int reverse(int x) {
    long r = 0;
    for (; x != 0; x /= 10) {
      r = 10 * r + x % 10;
    }
    return r > Integer.MAX_VALUE || r < Integer.MIN_VALUE ? 0 : (int) r;
  }
}
