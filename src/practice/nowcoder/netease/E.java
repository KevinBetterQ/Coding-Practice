package practice.nowcoder.netease;

import java.util.Scanner;

/**  
 * @category 数学题
 *
* Description:小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
* 一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
* 当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。
* 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,
* 小易希望你来帮他计算一下他最多能独立生活多少天。
* @author qwk  
* 
* 总结：数学题，列个方程很容易
*/
public class E {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long x = scanner.nextInt();
		long f = scanner.nextInt();
		long d = scanner.nextInt();
		long p = scanner.nextInt();
		long nday = 0;
		if(f > d/x) nday = d/x;
		else {
			nday = (d+p*f)/(x+p);
		}
		System.out.println(nday);
		scanner.close();

	}

}
