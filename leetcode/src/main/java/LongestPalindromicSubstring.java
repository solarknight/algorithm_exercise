/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * {@see https://leetcode.com/problems/longest-palindromic-substring/#/description}
 * <p>
 * Created by solarknight on 2017/4/17.
 */
public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }

    char[] c = process(s);
    int[] p = new int[c.length];
    int idx = 0, right = 0, mIdx = 0;

    for (int i = 1; i < c.length - 1; i++) {
      p[i] = right > i ? Math.min(p[2 * idx - i], right - i) : 0;
      while (c[i + p[i] + 1] == c[i - p[i] - 1]) {
        p[i]++;
      }
      if (i + p[i] > right) {
        right = i + p[i];
        idx = i;
      }
      if (p[i] > p[mIdx]) {
        mIdx = i;
      }
    }

    int start = (mIdx - p[mIdx] - 1) / 2;
    return s.substring(start, start + p[mIdx]);
  }

  private char[] process(String s) {
    char[] origin = s.toCharArray();
    char[] after = new char[origin.length * 2 + 3];

    after[0] = '^';
    after[after.length - 1] = '$';
    for (int i = 1, j = 0; i < after.length - 1; i++) {
      after[i] = i % 2 != 0 ? '#' : origin[j++];
    }
    return after;
  }

  public static void main(String[] args) {
    LongestPalindromicSubstring demo = new LongestPalindromicSubstring();
    System.out.println(demo.longestPalindrome("aba"));
    System.out.println(demo.longestPalindrome("abbacabbaf"));
  }
}
