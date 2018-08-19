package question1_25;

/**
 * Container with most water
 * {@see https://leetcode.com/problems/container-with-most-water/#/description}
 * <p>
 * Created by solarknight on 2017/4/30.
 */
public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    int max = 0;
    for (int i = 0, j = height.length - 1; i < j; ) {
      max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
      if (height[i] < height[j]) {
        do {
          i++;
        } while (height[i] <= height[i - 1] && i < j);
      } else {
        do {
          j--;
        } while (height[j] <= height[j + 1] && i < j);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    ContainerWithMostWater demo = new ContainerWithMostWater();
    System.out.println(demo.maxArea(new int[]{1, 2}));
  }
}
