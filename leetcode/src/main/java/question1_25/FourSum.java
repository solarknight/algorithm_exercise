package question1_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by solarknight on 2017/5/7.
 */
public class FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 4) {
      return res;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j != i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int k = j + 1, l = nums.length - 1, tar = target - nums[i] - nums[j];
        while (k < l) {
          if (nums[k] + nums[l] == tar) {
            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
            k++;
            l--;
            while (k < l && nums[k] == nums[k - 1]) {
              k++;
            }
            while (k < l && nums[l] == nums[l + 1]) {
              l--;
            }
          } else if (nums[k] + nums[l] < tar) {
            k++;
          } else {
            l--;
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    FourSum demo = new FourSum();
    System.out.println(demo.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
  }
}
