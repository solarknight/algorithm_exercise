package question26_50;

import java.util.Arrays;

/**
 * @author solarknight created on Aug 19, 2018
 * @version 1.0
 */
public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
      return 0;
    }

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      if (nums[left] == val) {
        nums[left] = nums[right--];
      } else {
        left++;
      }
    }
    return right + 1;
  }


  public static void main(String[] args) {
    RemoveElement demo = new RemoveElement();
    int[] nums = new int[]{3, 2, 2, 3};
    System.out.println(demo.removeElement(nums, 3));
    System.out.println(Arrays.toString(nums));


    nums = new int[]{1};
    System.out.println(demo.removeElement(nums, 1));
    System.out.println(Arrays.toString(nums));
  }
}
