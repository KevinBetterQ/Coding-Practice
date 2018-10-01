package com.contest514.one;

import java.util.Scanner;

/**  
* 类说明   ：Cover Points
*  
* @author ****  
* @date 2018年10月1日  新建  
*/
public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dis = 0;
		for(int i=0; i<n; i++){
			int x = in.nextInt();
			int y = in.nextInt();
			if(x + y > dis){
				dis = x + y;
			}
		}
		System.out.println(dis);
		in.close();
	}
	
	//Best Solution. Concise!
	public static void bestSolution(){
		Scanner in = new Scanner(System.in);
		int n,x,y,ans=0;
		n = in.nextInt();
		for(int i=0;i<n;i++){
			x = in.nextInt();
			y = in.nextInt();
			ans = Math.max(ans, x+y);
		}
		System.out.println(ans);
	}
}
