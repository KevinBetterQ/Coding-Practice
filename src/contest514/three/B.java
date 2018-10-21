package contest514.three;
/**  
* Description:
* @author qwk  
*/
public class B {
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.minFlipsMonoIncr("0101100011"));
		System.out.println(b.minFlipsMonoIncr("00110"));
		System.out.println(b.minFlipsMonoIncr("010110"));
		System.out.println(b.minFlipsMonoIncr("00011000"));
		System.out.println(b.minFlipsMonoIncr("10011111110010111011"));
		System.out.println(b.minFlipsMonoIncr("11011"));
		
		
	}
	//最佳AC代码，主要思想是，找一个划分点，左边的1的个数+右边0的个数最小即为翻转数
	public int minFlipsMonoIncr(String S) {
		if(S.length() == 1) return 0;
        int res = Integer.MAX_VALUE;
        int cnt0 = 0;
        int cnt1 = 0;
        for(int i = 0; i < S.length(); i++) {
        	if(S.charAt(i) == '0') cnt0++;
        }
        //从-1开始划分，也就是第0个左边
        if((cnt1 + cnt0) < res ) {
    		res = cnt1 + cnt0;
    	}
        //循环从0-length的右边开始划分
        for(int i = 0; i < S.length(); i++) {
        	if(S.charAt(i) == '1') cnt1++;
        	else cnt0--;
        	if((cnt1 + cnt0) < res ) {
        		res = cnt1 + cnt0;
        	}
        	
        }
        return res;
    }
	
	//递归法，超时了。。。
	/*public int minFlipsMonoIncr(String S) {
		
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '1') {
				//将1变为0的情况：
				count1 = 1 + minFlipsMonoIncr(S.substring(i+1));
				//1不变的情况：
				for(int j = i + 1; j < S.length(); j++) {
					if(S.charAt(j) == '0') count2++;
				}
				return Math.min(count1, count2);
			}
		}
		
		return 0;
	}*/
	
	
	//错误：0101100011、"10011111110010111011"
	/*public int minFlipsMonoIncr(String S) {
		int len = S.length();
		int newlen = len;
		for(int i = len - 1; i >= 0; i--) {
			if(S.charAt(i) != '1') {
				newlen = i + 1;
				break;
			}
		}
		S = S.substring(0, newlen);
			
		int count1 = 0;
		int count0 = 0;
		int countFlag = 0;
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '1') {
				countFlag = 1;
			}
			if(countFlag == 1){
				if(S.charAt(i) == '0') count0++;
				else if(S.charAt(i) == '1') count1++;
			}
		}
		
		
		return count0 < count1 ? count0 : count1;
        
    }*/
	
	//00011000
	/*public int minFlipsMonoIncr(String S) {
		if(S == null || S.length() == 0) return 0;
		int count0 = 0;
		int count1 = 0;
		int flag = -1;
		for(int i = 0; i < S.length() - 1; i++ ) {
			if(S.charAt(i+1) != S.charAt(i)) {//10或01
				flag = i;
				break;
			}
			
		}
		if(flag == -1 ) return 0;
		else{
			String newStr0 = "00" + S.substring(flag + 2);
			count0 = 1 + minFlipsMonoIncr(newStr0);
			//变为11
			int temp = 0;
			for(int jj = flag + 1; jj < S.length(); jj++){
				if(S.charAt(jj) == '0') {
					temp++;
				}
			}
			//String newStr1 = "11" + S.substring(flag + 2);
			count1 = temp;
		}
		return count0 < count1 ? count0 : count1;
    }*/
	
	//-------------------AC代码----------------------------------
	
	//分别记录左边1的个数和右边0的个数，什么时候相加等于最小了，就是要翻转的个数了！！！！！
	/*int minFlipsMonoIncr(string S) {
        int cnt1 = 0; //记录右边0的个数
        for(char c : S) cnt1 += (c == '0');
        int cnt2 = 0; //记录左边1的个数
        int ans = S.size();
        for(char c : S) {
            ans = min(ans, cnt1 + cnt2);
            if(c == '1') cnt2++;
            else cnt1--;
        }
        ans = min(ans, cnt1 + cnt2);
        return ans;
    }*/
	
	
	/*AC code
	 public int minFlipsMonoIncr(String S) {
       int n=S.length();
        int[] leftone= new int[n];
        int[] rightzero=new int[n];
        char[] sc= S.toCharArray();
        for(int i=0;i<n;i++){
            if(sc[i]=='1') leftone[i]=1;
            if(i>0) leftone[i]=leftone[i]+leftone[i-1];
        }
        
        for(int i=n-1;i>=0;i--){
            if(sc[i]=='0') rightzero[i]=1;
            if(i<n-1) rightzero[i]=rightzero[i]+rightzero[i+1];
        }
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int left= i==0? 0 : leftone[i-1];
            int right= i==n-1? 0: rightzero[i+1];
           min= Math.min(min,left+right);
        }
        return min;
    }
	 
	 
	 
	 */
}
