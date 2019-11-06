import java.awt.event.HierarchyBoundsAdapter;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 */
public class LeetCode_11_570 {

    // 单向遍历 O(n^2)
    public int maxArea(int[] height) {
        int max = 0;
        // 宽度 * 高度
        for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length; j++) {
                // 宽：j-1，高：max(height[i], height[j])
                int area = (j-i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    // 双向收敛 O(n)
    public int maxArea2(int[] height) {
        int max = 0;
        // 宽度 * 高度
        for (int i=0,j=height.length-1; i<j; ) {
            // 宽：j-1，高：max(height[i], height[j])
            int hi = (height[i]<height[j]) ? height[i++] : height[j--];
            int area = (j-i+1) * hi;
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new LeetCode_11_570().maxArea2(height));
//        System.out.println(new LeetCode_11_570().maxArea(height));
    }
}
