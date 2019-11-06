import java.util.ArrayList;
import java.util.List;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class LeetCode_70_570 {

    // f(n) = f(n-1) + f(n-2) 问题
    // 递归
    public int climbStairs(int n) {
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        return (climbStairs(n-1) + climbStairs(n-2));
    }

    public int climbStairs2(int n) {
        if (n < 1) {
            System.err.println("["+n+"] is invalid");
            return 0;
        } else if (1 == n) {
            return 1;
        } else if (2 == n) {
            return 2;
        }else {
            int a1 = 1;
            int a2 = 2;
            int a = 0;
            for (int i = 3; i <= n; i++) {
                a = a1 + a2;
                a1 = a2;
                a2 = a;
            }
            return a;
        }
    }

    public static void main(String[] args) {

        System.out.println(new LeetCode_70_570().climbStairs2(3));
        System.out.println(new LeetCode_70_570().climbStairs2(5));
    }
}
