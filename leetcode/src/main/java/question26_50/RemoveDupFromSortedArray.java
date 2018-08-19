package question26_50;

import java.util.Arrays;

/**
 * @author solarknight created on Aug 19, 2018
 * @version 1.0
 */
public class RemoveDupFromSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return nums.length;
    }

    int start = 0, cur = 1;
    while (cur < nums.length) {
      if (nums[cur] != nums[start]) {
        nums[++start] = nums[cur];
      }
      cur++;
    }
    return start + 1;
  }

  public static void main(String[] args) {
    RemoveDupFromSortedArray demo = new RemoveDupFromSortedArray();
    int[] nums = new int[]{2, 2, 3, 4, 5, 5, 7, 7, 7};
    System.out.println(demo.removeDuplicates(nums));
    System.out.println(Arrays.toString(nums));
  }
}
