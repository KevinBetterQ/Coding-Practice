package practice.nowcoder.netease;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @category 找规律
 * 
 * Description:小易有一个长度为n的整数序列,a_1,...,a_n。
 * 然后考虑在一个空序列b上进行n次以下操作: 
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列 小易需要你计算输出操作n次之后的b序列。
 * 
 * @author qwk
 * 总结反思：规律题，Array比List快，有时间限制的话，还是使用数组吧
 */
public class D {

	//通过。果然数组还是比List快呀！！
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int start = 0, end = n-1;
        
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for(int i = n-1; i >= 0; i--) {
        	if((n-i) % 2 == 0) {
            	b[end] = a[i];
            	end--;
            }
            else {
            	b[start] = a[i];
            	start++;
            }
        }
        
        System.out.print(b[0]);
        for(int i = 1; i < n; i++) {
        	System.out.print(" " + b[i]);
        }
        scanner.close();

	}
	
	//用LinkedList超时！！
	/*public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int[] a = new int[n];
        int a;
        LinkedList<Integer> b = new LinkedList<>();
        for(int i =0; i < n; i++) {
            a = scanner.nextInt();
            if((n-i) % 2 == 0) b.addLast(a);
            else b.addFirst(a);
        }
        
        System.out.print(b.get(0));
        for(int i = 1; i < n; i++) {
        	System.out.print(" " + b.get(i));
        }
        scanner.close();

	}*/

}
