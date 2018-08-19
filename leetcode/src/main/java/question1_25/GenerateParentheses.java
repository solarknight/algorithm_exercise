package question1_25;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by solarknight on 2017/5/10.
 */
public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }
    char[] c = new char[2 * n];
    recursive(res, c, 0, n, 0, 0);
    return res;
  }

  public void recursive(List<String> result, char[] c, int idx, int max, int open, int close) {
    if (idx == c.length) {
      result.add(new String(c));
      return;
    }
    if (open < max) {
      c[idx] = '(';
      recursive(result, c, idx + 1, max, open + 1, close);
    }
    if (close < open) {
      c[idx] = ')';
      recursive(result, c, idx + 1, max, open, close + 1);
    }
  }

  public static void main(String[] args) {
    GenerateParentheses demo = new GenerateParentheses();
    print(demo.generateParenthesis(2));
  }

  private static void print(List<String> list) {
    for (String str : list) {
      System.out.println(str);
    }
  }
}
