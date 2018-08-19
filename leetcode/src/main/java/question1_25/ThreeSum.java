package question1_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by solarknight on 2017/5/4.
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if (nums == null || nums.length < 3) {
      return list;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int tar = -nums[i], j = i + 1, k = nums.length - 1;
      while (j < k) {
        if (nums[j] + nums[k] == tar) {
          list.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
          while (j < k && nums[j] == nums[j - 1]) {
            j++;
          }
          while (j < k && nums[k] == nums[k + 1]) {
            k--;
          }
        } else if (nums[j] + nums[k] < tar) {
          j++;
        } else {
          k--;
        }
      }
    }
    return list;
  }

  public static void main(String[] args) {
    ThreeSum demo = new ThreeSum();
    System.out.println(demo.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }

}
