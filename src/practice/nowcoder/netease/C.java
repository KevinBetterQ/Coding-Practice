package practice.nowcoder.netease;

import java.util.Scanner;

/**
 * @category 数列和串
 * 
 * Description:如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 * 
 * @author qwk
 * 
 * 总结反思：对于串，数列的问题，想算法时最好注意就遍历一遍，在便利过程中将需要的东西用一个数据结构记录下来。
 */
public class C {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		int n = s.length();
		int ans = 0;
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				count++;
			} else {
				ans = ans > count ? ans : count;
				count = 1;
			}
		}
		ans = ans > count ? ans : count;
		System.out.println(ans);
		scanner.close();
	}

}
