package com.roman.procopenco.codewars;

/**
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
 *
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * // should be 6: {4, -1, 2, 1}
 * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
 *
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */
public class MaximumSubarraySum {

  /**
   * See Kadane's Algorithm https://www.youtube.com/watch?v=86CQq3pKSUw&ab_channel=CSDojo
   */
  public static int sequence(int[] arr) {
    if (arr.length == 0) return 0;

    int maxCurrent, maxGlobal;
    maxCurrent = maxGlobal = arr[0];

    for (int i = 1; i < arr.length; i++) {
      maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
      if (maxCurrent > maxGlobal) {
        maxGlobal = maxCurrent;
      }
    }

    return maxGlobal > 0 ? maxGlobal : 0;
  }

}
