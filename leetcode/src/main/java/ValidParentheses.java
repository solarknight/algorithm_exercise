import java.util.Stack;

/**
 * Created by solarknight on 2017/5/7.
 */
public class ValidParentheses {

  public boolean isValid(String s) {
    if (s.length() == 0) {
      return true;
    }
    if (s.length() == 1) {
      return false;
    }
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (stack.size() != 0 && stack.peek() == c) {
        stack.pop();
        continue;
      }
      if (c == '(') {
        stack.push(')');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '{') {
        stack.push('}');
      } else {
        return false;
      }
    }
    return stack.size() == 0;
  }

  public static void main(String[] args) {
    ValidParentheses demo = new ValidParentheses();
    System.out.println(demo.isValid("()[]"));
    System.out.println(demo.isValid("){"));
    System.out.println(demo.isValid("([])"));
    System.out.println(demo.isValid("()"));
    System.out.println(demo.isValid("([)"));
  }

}
