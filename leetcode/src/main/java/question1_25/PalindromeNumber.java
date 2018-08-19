package question1_25;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * {@see https://leetcode.com/problems/palindrome-number/#/description}
 * <p>
 * Created by solarknight on 2017/4/24.
 */
public class PalindromeNumber {

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    if (x >= 0 && x < 10) {
      return true;
    }
    if (x % 10 == 0) {
      return false;
    }
    int rev = 0;
    for (; x > rev; x /= 10) {
      rev = 10 * rev + x % 10;
    }
    return x == rev || x == rev / 10;
  }

  public static void main(String[] args) {
    System.out.println(new PalindromeNumber().isPalindrome(121));
    System.out.println(new PalindromeNumber().isPalindrome(1221));
    System.out.println(new PalindromeNumber().isPalindrome(10));
    System.out.println(new PalindromeNumber().isPalindrome(0));
  }
}
