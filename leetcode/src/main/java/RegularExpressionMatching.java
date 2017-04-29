/**
 * Implement regular expression matching with support for '.' and '*'.<br/>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * {@see https://leetcode.com/problems/regular-expression-matching/#/description}
 * <p>
 * Created by solarknight on 2017/4/27.
 */
public class RegularExpressionMatching {

  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 1; i < p.length(); i++) {
      dp[0][i + 1] = p.charAt(i) == '*' && dp[0][i - 1];
    }

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (p.charAt(j) == s.charAt(i)) {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == '*') {
          if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
            dp[i + 1][j + 1] = dp[i + 1][j - 1];
          } else {
            // zero || one || multi (count >= 2)
            dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }

  public static void main(String[] args) {
    RegularExpressionMatching demo = new RegularExpressionMatching();
    System.out.println(demo.isMatch("aaa", "aa"));
    System.out.println(demo.isMatch("ab", ".*"));
    System.out.println(demo.isMatch("aab", "c*a*b"));
  }
}
