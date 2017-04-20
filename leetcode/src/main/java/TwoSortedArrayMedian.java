/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.<p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * {@see https://leetcode.com/problems/median-of-two-sorted-arrays/#/description}
 *
 * @author solarknight.zph created on 17/4/8 下午8:19
 * @version 1.0
 */
public class TwoSortedArrayMedian {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int l1 = nums1.length, l2 = nums2.length;
    if (l1 > l2) {
      return findMedianSortedArrays(nums2, nums1);
    }

    if (l1 == 0) {
      return (nums2[(l2 - 1) / 2] + nums2[l2 / 2]) / 2.0;
    }

    int left = 0, right = 2 * l1;
    while (left <= right) {
      int mid1 = (left + right) / 2;
      int mid2 = l1 + l2 - mid1;

      int lv1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
      int rv1 = mid1 == 2 * l1 ? Integer.MAX_VALUE : nums1[mid1 / 2];
      int lv2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
      int rv2 = mid2 == 2 * l2 ? Integer.MAX_VALUE : nums2[mid2 / 2];

      if (lv1 <= rv2 && lv2 <= rv1) {
        return (Math.max(lv1, lv2) + Math.min(rv1, rv2)) / 2.0;
      } else if (lv1 > rv2) {
        right = mid1 - 1;
      } else {
        left = mid1 + 1;
      }
    }
    return -1;
  }


  public static void main(String[] args) {
    int[] array1, array2;
    array1 = new int[]{1, 3};
    array2 = new int[]{2};
    System.out.println(findMedianSortedArrays(array1, array2));

    array1 = new int[]{1, 2};
    array2 = new int[]{3, 4};
    System.out.println(findMedianSortedArrays(array1, array2));

    array1 = new int[]{6, 10};
    array2 = new int[]{1, 2, 3, 4, 5, 7, 8, 9};
    System.out.println(findMedianSortedArrays(array1, array2));
  }
}
