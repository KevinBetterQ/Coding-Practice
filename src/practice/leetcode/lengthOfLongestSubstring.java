package practice.leetcode;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * @category :数列遍历问题
 * 总结：滑动窗口
 * 
 * Description：无重复字符的最长子串
 * @author qwk
 * @date 2018年10月6日
 */
public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		lengthOfLongestSubstring pram = new lengthOfLongestSubstring();
		int a = pram.solution("sd");
		int b = pram.bestSolution("sd");
		System.out.println(a);
		System.out.println(b);

	}

	public int solution(String s) {
		int longest = 0;
		for (int i = 0; i < s.length(); i++) {
			String currStr = String.valueOf(s.charAt(i));
			for (int j = i + 1; j < s.length(); j++) {
				if (currStr.contains(String.valueOf(s.charAt(j)))) {
					if (longest < currStr.length()) longest = currStr.length();
					break;
				} else {
					currStr = currStr + s.charAt(j);
				}
			}
			if (longest < currStr.length()) longest = currStr.length();
		}
		return longest;
	}
	
	//滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j) 向右滑动 11 个元素，则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）
	//优化的滑动窗口
	//优化：如果 s[j]在 [i, j)范围内有重复的字符j`，我们不需要逐渐增加 i，而是直接将i跳过[i,j`]范围内的所有元素
	public int bestSolution(String s) {
		int n = s.length(), ans = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int j = 0,i = 0; j < n; j++) {
			if(map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

}











