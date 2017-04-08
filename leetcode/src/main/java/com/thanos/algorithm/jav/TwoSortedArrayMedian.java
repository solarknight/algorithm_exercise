package com.thanos.algorithm.jav;

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
  }
}
