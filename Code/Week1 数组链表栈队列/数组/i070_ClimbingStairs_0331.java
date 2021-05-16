package ArrayLinked;
import java.util.*;
/*70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
示例：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
*/

public class i070_ClimbingStairs_0331 {
	/*
	 * @param: n
	 * @description: 动态规划
	 * @return: int
	 */
	public int climbStairs1(int n) {
		int[] dp = new int[n+1];
		int ans = 0;

		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3;i <= n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		if(n == 1 || n == 2) {
			ans = n;
		}
		ans = dp[n];
		return ans;
	}
	public static void main(String[] args) {
		i070_ClimbingStairs_0331 test = new i070_ClimbingStairs_0331();
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();*/
		int n = 36;
		int ans = test.climbStairs1(n);
		System.out.println(ans);
	}
}
