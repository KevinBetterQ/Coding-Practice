package practice.lintcode.alibaba;

import java.util.HashMap;

/**  
* Description:最长AB字串
* @author qwk  
* idea：
	for循环, 如果当前是A, count++. 是B, count--.
	hashmap用来存储, A出现的个数和对应的起始位置.只有当A出现的个数之前没存过时才put，存过的话说明之前达到过这个状态，这中间会产生一个AB相等的字串
	(也可以理解为，hashmap的key是存储一种特定状态，这里用A的个数表示)
	
	在for循环的过程中, 只要存在hashmap曾经出现过的A的个数, 这时候只需要从 当前位置 减去 之前出现相同A个数的位置 ，这中间AB的个数就是相等的。
	（也可以理解为：之前达到了一种状态，接着遍历，当再达到这种状态时，说明这个过程中间的AB是相互抵消的），
	所以，i - map.get(count)就是这个状态下的AB字串长度。
	更新ans为max(ans, i - map.get(count)).
*
*/
public class LongestABsubstring {

	public static void main(String[] args) {
		LongestABsubstring result = new LongestABsubstring();
		System.out.println(result.getAns("ABAAABBBA"));
		System.out.println(result.getAns("AAAAAA"));

	}

	 /**
     * @param S: a String consists of a and b
     * @return: the longest of the longest string that meets the condition
     */
	public int getAns(String S) {
        if(S == null || S.length() == 0 || S.length() == 1) 
    		return 0;
    	int ans = 0; 
    	int count = 0;
    	HashMap<Integer, Integer> map = new HashMap<>();
    	map.put(0, 0);
        for(int i = 1; i <= S.length(); i++) {
        	if(S.charAt(i - 1) == 'A') count++;
        	else count--;
        	
        	if(map.containsKey(count)){
        		ans = Math.max(ans, i - map.get(count));
        	}else{
        		map.put(count, i);
        	}
        }
        return ans;
    }
}















