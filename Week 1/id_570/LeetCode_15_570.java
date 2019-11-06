import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class LeetCode_15_570 {

    // 1、暴力求解：三重循环遍历
    // Q：怎么去重？
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer[]> tem = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                loop: for (int k = j+1; k<nums.length; k++) {
                    if (0 == (nums[i]+nums[j]+nums[k])) {
                        Integer[] cur = new Integer[]{nums[i], nums[j], nums[k]};
                        Arrays.sort(cur);
                        for (int m=0; m<tem.size(); m++) {
                            if (Arrays.equals(tem.get(m), cur)) {
                                continue loop;
                            }
                        }
                        tem.add(cur);
                        result.add(Arrays.asList(cur));
                    }
                }
            }
        }
        return result;
    }


    // 左右收敛：三指标左右同时收敛
    // 1、k 从左向右遍历元素
    // 2、i j 从 [k+1, length] 开始左右收敛，根据 i、j之和与k比较结果决定i右移或j左移
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k=0; k<nums.length-2; k++) {
            // k>0 => sum>0
            if (nums[k] > 0) {
                break;
            }
            // 跳过重复元素
            if (k>0 && nums[k]==nums[k-1]) {
                continue;
            }
            System.out.println(k);

            for (int i=k+1, j=nums.length-1; i<j; ) {
                if (i == j) break;
                if (nums[i] + nums[j] > -nums[k]) {
                    j--;
                    continue;
                } else if (nums[i] + nums[j] < -nums[k]) {
                    i++;
                    continue;
                }
                if(nums[i] + nums[j] == -nums[k]) {
                    if(i>k+1 && nums[i]==nums[i-1]) {
                        i++;
                        continue;
                    }
                    if (j<nums.length-1 && nums[j]==nums[j+1]) {
                        j--;
                        continue;
                    }
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++; j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};
//        int[] nums = {-1, 0, 0, 2, -1, -4};
//        int[] nums1 = {-1, 0, 2, 2, -1, -4};
        System.out.println(new LeetCode_15_570().threeSum2(nums));

    }
}
