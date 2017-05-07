import java.util.ArrayList;
import java.util.List;

/**
 * Created by solarknight on 2017/5/7.
 */
public class LetterCombinations {

  private static final char[][] LETTERS = {{' '}, {' '}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
      {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }
    List<String> res = new ArrayList<>();
    res.add("");

    for (char c : digits.toCharArray()) {
      int t = c - '0';
      List<String> tmp = new ArrayList<>(res.size() * LETTERS[t].length);
      for (char p : LETTERS[t]) {
        for (String s : res) {
          tmp.add(s + p);
        }
      }
      res = tmp;
    }
    return res;
  }

  public List<String> letterCombinations2(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }
    List<String> res = new ArrayList<>();
    char[] chars = new char[digits.length()];
    recursive(digits, 0, chars, res);
    return res;
  }

  private void recursive(String digits, int idx, char[] chars, List<String> res) {
    if (idx == digits.length()) {
      res.add(new String(chars));
      return;
    }

    for (char c : LETTERS[digits.charAt(idx) - '0']) {
      chars[idx] = c;
      recursive(digits, idx + 1, chars, res);
    }
  }


  public static void main(String[] args) {
    LetterCombinations demo = new LetterCombinations();
//    System.out.println(demo.letterCombinations2("2"));
    System.out.println(demo.letterCombinations2("234").size());
    System.out.println(demo.letterCombinations2("234"));
  }
}
