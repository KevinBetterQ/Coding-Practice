package contest514.two;
/**  
* @Description:
* @author qwk  
* @date 2018年10月7日  
*/
public class b_maxSubarraySumCircular {

	public static void main(String[] args) {
		b_maxSubarraySumCircular pram = new b_maxSubarraySumCircular();
		int[] x = {5,-3,5};
		int a = pram.maxSubarraySumCircular(x);	
		System.out.println(a);

	}
	
	public int maxSubarraySumCircular(int[] A) {
		int ans = A[0];
		for(int i = 0; i < A.length; i++){
			ans = ans < A[i] ? A[i] : ans;
		}
		
		for(int i = 0; i < A.length; i++) {
			int sum = A[i];
			for(int j = i + 1; ; j++) {
				//System.out.println(j + " " + A.length + " " + j % A.length);
				if((j >= A.length) && (j % A.length >= i)) break;
				//if(ans < sumab(A, i, j % A.length)) ans = sumab(A, i, j % A.length);
				
				sum = sum + A[j % A.length];
				if(ans < sum) ans = sum;
			}
		}
		
		return ans;
    }
	
	public static int sumab(int[] A, int a, int b){
		int sum = 0;
		if(b < a){
			for(int i = a; i < A.length; i++){
				sum += A[i];
			}
			for(int i = 0; i <= b; i++){
				sum += A[i];
			}
		}else {
			for(int i = a; i <= b; i++){
				sum += A[i];
			}
		}
		
		return sum;
	}

}
