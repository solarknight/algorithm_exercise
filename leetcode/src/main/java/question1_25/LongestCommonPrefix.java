package question1_25;

/**
 * Created by solarknight on 2017/5/3.
 */
public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String tmp = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(tmp) != 0)
        tmp = tmp.substring(0, tmp.length() - 1);
    }
    return tmp;
  }

  public static void main(String[] args) {
    LongestCommonPrefix demo = new LongestCommonPrefix();
    demo.longestCommonPrefix(new String[]{"", ""});
  }
}
