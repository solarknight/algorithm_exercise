package com.thanos.algorithm.jav;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * {@see https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description}
 * <p>
 * Created by solarknight on 2017/4/6.
 */
public class LengthOfLongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    char[] c = s.toCharArray();
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int pIdx = 0, idx = 0, max = 0;

    for (; idx < c.length; idx++) {
      if (map.containsKey(c[idx])) {
        max = (idx - pIdx) > max ? (idx - pIdx) : max;
        pIdx = (map.get(c[idx]) + 1 > pIdx) ? (map.get(c[idx]) + 1) : pIdx;
      }
      map.put(c[idx], idx);
    }
    max = (idx - pIdx) > max ? (idx - pIdx) : max;
    return max;
  }

  public static void main(String[] args) {
    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("advdfghmfi"));
    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("ibaz"));
    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
  }
}
