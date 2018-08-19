package question1_25;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.<br/>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * {@see https://leetcode.com/problems/two-sum/#/description}
 *
 * Created by solarknight on 2017/4/4.
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      int tmp = target - nums[i];
      if (map.containsKey(tmp)) {
        return new int[]{map.get(tmp), i};
      } else {
        map.put(nums[i], i);
      }
    }
    return null;
  }
}
