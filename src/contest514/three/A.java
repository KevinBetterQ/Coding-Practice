package contest514.three;

import java.util.Scanner;

/**  
* Description:
* @author qwk  
*/
public class A {

	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.isLongPressedName("pyplrz", "ppyypllr"));
	}
	
	public boolean isLongPressedName(String name, String typed) {
		if(name == null || typed == null ) return false;
		if(name.length() == 0 || typed.length() == 0) return false;
		if(name.charAt(0) != typed.charAt(0)) return false;
		if(name.length() > typed.length()) return false;
		int j = 1;
		for(int i = 1 ; i < name.length(); ){
			if(name.charAt(i) == typed.charAt(j)){
				i++;
				j++;
				
			}else{
				if(typed.charAt(j) == typed.charAt(j-1)) {
					j++;
					
				} else {
					
					return false;
				}
			}
			if(j >= typed.length() && i < name.length()) return false;
		}
		for(; j < typed.length(); j++) {
			if(typed.charAt(j) != typed.charAt(j-1)){
				return false;
			}
		}
		return true;
        
    }

}
