package contest514.two;

import jdk.internal.dynalink.beans.StaticClass;
import sun.print.resources.serviceui;

/**  
* @Description:
* @author qwk  
* @date 2018年10月7日  
*/
public class a_InverseLetter {

	public static void main(String[] args) {
		
		a_InverseLetter pram = new a_InverseLetter();
		String a = pram.reverseOnlyLetters2("Test1ng-Leet=code-Q!");	
		System.out.println(a);
		
	}
	
	//通过
	public String reverseOnlyLetters2(String S) {
		char[] strchars = S.toCharArray();
		int n = S.length();
		int p = 0, q = n - 1;
		while (p < q) {
			if(isLetter(S.charAt(p)) && isLetter(S.charAt(q))) {
				char tmp = strchars[p];
				strchars[p] = strchars[q];
				strchars[q] = tmp;
				p++; q--;
			}else {
				if(!isLetter(S.charAt(p))) p++;
				if(!isLetter(S.charAt(q))) q--;
			}
			
		}
		
		return String.valueOf(strchars);
    }
	public static boolean isLetter(char x) {
		if((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z'))
			return true;
		return false;
	}
	
	//
	public String reverseOnlyLetters(String S) {
		if(S == null || S.length() <= 0) return S;
		char[] newchars = new char[S.length()];
		char[] charstr = new char[S.length()];
		int j = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
        	if(S.charAt(i) >= 'a' && S.charAt(i) <= 'z' ) {
        		newchars[j] = S.charAt(i);
        		j++;
        	}else if(S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') {
        		newchars[j] = S.charAt(i);
        		j++;
        	}
        }
        j = 0;
        for(int i = 0; i < S.length(); i++) {
        	if((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
        		charstr[i] = newchars[j];
        		j++;
        	}else{
        		charstr[i] = S.charAt(i);
        	}
        }
        
        return String.valueOf(charstr);
    }

}
