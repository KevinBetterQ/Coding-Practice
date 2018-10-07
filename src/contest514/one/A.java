package contest514.one;

import java.util.Scanner;

/**  
* 类说明   ：Little C loves 3 I
*  
* @author qwk  
* @date 2018年10月1日  新建  
*/
public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.print("1 ");
		for(int i=1; i<=n; i++){
			if((i%3!=0)&&((n-1-i)%3!=0)){
				System.out.println(i + " " + (n-1-i));
				break;
			}
		}
	}
	
	// Best solution
	public static void bestSolution(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if((n-2)%3!=0) System.out.println("1 1 " + (n-2));
		else System.out.println("1 2 " + (n-3));
	}
	
}