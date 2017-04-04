package com.thanos.algorithm.jav;

import java.util.HashMap;
import java.util.Map;

/**
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
