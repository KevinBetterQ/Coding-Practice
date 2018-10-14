package practice.nowcoder.netease;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @category 理解题
 * 
 * Description:
 * 小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。现在有一个给定的字符串s,s中每个字符代表小易的某个砖块的颜色。
 * 小易想把他所有的砖块排成一行。如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。(
 * 如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。) 
 * 例如: s = "ABAB",那么小易有六种排列的结果:
 * "AABB","ABAB","ABBA","BAAB","BABA","BBAA" 
 * 其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。
 * 
 * @author qwk
 * 
 * 总结收获：注意掌握 HashSet 的使用，集合用于没有重复元素的存储使用。
 */
public class A {
	
	//自己实现代码
	/*public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			int count = 1;
			if(!map.containsKey(tmp)) map.put(tmp, 1);
			else {
				count = map.get(tmp);
				map.put(tmp, count + 1);
			}
		}
		
		int colors = map.size();
		if(colors == 1) System.out.println(1);
		else if(colors == 2) System.out.println(2);
		else {
			System.out.println(0);
		}
		scanner.close();

	}*/
	
	//利用HashSet集合实现
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		HashSet<String> hashSet = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			hashSet.add(String.valueOf(s.charAt(i)));
			if(hashSet.size() > 2) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(hashSet.size());
		
		scanner.close();
	}
	

}









