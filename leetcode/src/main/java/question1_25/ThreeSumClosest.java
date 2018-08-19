package question1_25;

import java.util.Arrays;

/**
 * Created by solarknight on 2017/5/7.
 */
public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3) {
      return 0;
    }
    Arrays.sort(nums);
    int sum = 0, curShift = 0, minShift = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1, k = nums.length - 1, tar = target - nums[i];
      while (j < k) {
        curShift = nums[j] + nums[k] - tar;
        int abs = curShift < 0 ? -curShift : curShift;
        if (abs < minShift) {
          minShift = abs;
          sum = nums[i] + nums[j] + nums[k];
        }

        if (curShift == 0) {
          return target;
        } else if (curShift < 0) {
          j++;
        } else {
          k--;
        }
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    ThreeSumClosest demo = new ThreeSumClosest();
    assert demo.threeSumClosest(new int[]{0, 1, 2}, 0) == 3;
    assert demo.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2;
  }
}
