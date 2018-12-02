package sap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			int tmp = scanner.nextInt();
			if(!map.containsKey(tmp))
				map.put(tmp, 1);
			else{
				map.put(tmp, map.get(tmp)+1);
			}
		}
		//ArrayList<Integer> res = new ArrayList<>();
		/*int[] a = new int[N];
		int i = 0;*/
		int max = 0;
		int maxNum = 0;
		for(int k : map.keySet()) {
			if(map.get(k) > maxNum){
				max = k;
				maxNum = map.get(k);
			}
		}
		for(int k : map.keySet()) {
			if(map.get(k) == maxNum){
				System.out.println(k +" " + maxNum);
			}
		}
	}
	
}
