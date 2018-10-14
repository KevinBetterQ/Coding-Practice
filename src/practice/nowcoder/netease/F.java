package practice.nowcoder.netease;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @category 暴力，如何找到方法来暴力
 * 
 * -Description：小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。
 * 同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。
 * 小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.
 * 
 * @author qwk
 * 
 * -代码思路：本题的关键是找到一个最优的聚合点，使得各个棋子到这个聚合点的距离最短。
 * 暴力解题,枚举所有棋子到每个可能的(x,y)的曼哈顿距离。然后维护排序后的前k个点的最小值。
 * 可能的(x,y)就是:如果有旗子(x1,y1)和(x2,y2),那么所有可能的点就是(x1,y1),(x1,y2),(x2,y1),(x2,y2)
 * 
 * 三层循环，针对所有可能的聚合点，计算所有点到聚合点的距离存起来；
 * 然后利用存起来的各个点的距离，计算将1个棋子聚合、2个棋子聚合……n个棋子聚合需要的距离和
 * 然后每次聚合点不同时，更新下存储的不同个数聚合所需的距离和
 */
public class F {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int size = in.nextInt();
			int[] x = new int[size];
			int[] y = new int[size];
			for (int i = 0; i < size; i++) {
				x[i] = in.nextInt();
			}
			for (int i = 0; i < size; i++) {
				y[i] = in.nextInt();
			}
			
			int[] res = minOPs(size, x, y);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < size; i++) {
				result.append(String.valueOf(res[i]) + " ");
			}
			System.out.println(result.toString().trim());
		}
		in.close();
	}

	public static int[] minOPs(int size, int[] x, int[] y) {
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				//1、针对选择的聚合点（x[i],x[j]），计算所有点到其的距离并存储，存入PriorityQueue中
				for (int k = 0; k < size; k++) {
					/*曼哈顿距离，计算（x[k],y[k]）到（x[i],x[j]）的曼哈顿距离：
					 * Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j])
					 * 下面代码也就是将给出的任意的一点（x[k],y[k]）到每一个可能的聚合点（x[i],x[j]）的距离存起来
					*/
					pq.add(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
				}
				
				//2、更新不同个数棋子聚合所需的总距离，存入res[]中
				
				/* 这时候（x[i],x[j]）就是一个聚合点
				 * 而且上面已经计算出的所有点到（x[i],x[j]）这个聚合点的距离
				 * 这样我们要统计的不同个数的点聚合到一起需要的操作次数就可以循环得出
				 * 不断取出pg的最小距离，
				 * 对于1个棋子：取出一个就可以了
				 * 对于2个棋子：取出2个
				 * ……
				 * 下面利用res[resI]来记录在这个聚合点下，不同个棋子需要操作的个数
				 */
				int resI = 0;
				int sum = 0;
				while (!pq.isEmpty()) {
					sum += pq.poll();
					res[resI] = Math.min(res[resI], sum);
					resI++;
				}
			}
		}
		return res;
	}
}
