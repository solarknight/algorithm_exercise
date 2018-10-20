package question26_50;

/**
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * @author solarknight created on Oct 20, 2018
 * @version 1.0
 */
public class ImplementStr {

  public int strStr(String haystack, String needle) {
    if (needle == "") {
      return 0;
    }

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      int j = 0;
      while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
        j++;
      }

      if (j == needle.length()) {
        return i;
      }
    }

    return -1;
  }
}
