package practice.nowcoder.netease;

import java.util.Scanner;

/**
 * 
 * @category 状态空间更新
 * 
 * Description:
 * 小易非常喜欢拥有以下性质的数列: 
 * 1、数列的长度为n 
 * 2、数列中的每个数都在1到k之间(包括1和k)
 * 3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可) 例如,当n = 4, k = 7
 * 那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
 * 但是小易不喜欢{4,4,4,2}这个数列。
 * 小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
 * 
 * 
 * 思路：
 * 一个状态空间：dp[i][j]表示长度为i的序列以j结束数字的数列个数
 * 
 */
public class H {

	private static final int MOD = 1000000007;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int k = in.nextInt();
			//dp[i][j]表示长度为i的序列以j结束数字的数列个数
			//dp[i][j] = dp[i - 1][m] (1 <= m <= k)并且(m,j)是一个有效的序列
			int[][] dp = new int[n + 1][k + 1];
			dp[0][1] = 1;
			for (int i = 1; i <= n ;i++) {
				int sum = 0;
				//1、所有可能的组合记录下来
				for (int j = 1; j <= k; j++) {
					sum = (sum + dp[i-1][j]) % MOD;
				}
				
				//2、删除所有不满足条件的情况
				for (int j = 1; j <= k ; j++) {
					int invalid = 0;//记录无效的个数
					int p = 2;
					//这是一个巧妙的机制，假设本次取j，则上一次取j的倍数的都是 A % B != 0 的违反者，所以记为为无效个数
					while (p * j <= k) {
						//dp[i - 1][p * j]违反了A % B != 0，因此剔除
						invalid = (invalid + dp[i - 1][p * j]) % MOD;
						p++;
					}
					//为初始化增量
					dp[i][j] = (sum - invalid + MOD) % MOD;
				}
			}
			//3、n长度的所有情况相加
			int res = 0;
			for (int i = 1; i <= k ;i++) {
				res = (res + dp[n][i]) % MOD;
			}
			System.out.println(res);
		}
		in.close();

	}

}
