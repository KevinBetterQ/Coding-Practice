package practice.lintcode.alibaba;
/**  
* Description:
* 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，
* 并且返回新的数组的长度。
* 不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
* @author qwk  
* idea：充分利用原数组
*/
public class RemoveDuplicates {
	
	/*
	 * Best Solution!!!!
	 */
	public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) 
            return 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[size]) {
                nums[size + 1] = nums[i];
                size++;
            }
        }
        return size + 1;
    }
	
	
	
	/* solution-qwk
     * @param nums: An ineger array
     * @return: An integer
     */
    public int qwk_removeDuplicates(int[] nums) {
        int n = nums.length;
        if(nums.length <= 1) return nums.length;
        int count = 1;
        for(int i = 1; i < n; ) {
            if(nums[i] != nums[i-1]) {
                count++;
                i++;
            }
            else {
                for(int j = i; j < nums.length - 1; j++){
                    nums[j] = nums[j+1];
                }
                n--;
            }
        }
        return count;
    }
	
}
