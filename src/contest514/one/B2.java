package contest514.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**  
* 类说明   ：
*  
* @author ****  
* @date 2018年10月1日  新建  
*/
public class B2 {

	static class Point implements Comparable<Point>{
		int x;
		int y;
		public Point(int xi, int yi) {
			x = xi;
			y = yi;
		}
		
		@Override
		public int compareTo(Point o) {
			return (x+y)<(o.x+o.y)? 1:-1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Point> points = new ArrayList<Point>();
		for(int i=0;i<n;i++){
			int x = in.nextInt();
			int y = in.nextInt();
			points.add(new Point(x,y));
		}
		Collections.sort(points);
		System.out.println(points.get(0).x + points.get(0).y);
		in.close();
	}

}
