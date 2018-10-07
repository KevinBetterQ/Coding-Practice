package practice.leetcode;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * 类说明 ：
 * 
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
	
	//优化的滑动窗口
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











