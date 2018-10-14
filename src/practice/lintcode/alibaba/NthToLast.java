package practice.lintcode.alibaba;
/**  
* Description:链表倒数第n个节点
* @author qwk  
* idea: 注意遍历时i的设置，可以找个例子对着来设置，形象。
*/
public class NthToLast {
	
	
	 
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int val) {
	         this.val = val;
	         this.next = null;
	     }
	 }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode nthToLast(ListNode head, int n) {
        if(head == null) return null;
        ListNode curr = head;
        ListNode nlast = head;
        int i = 1;
        while(curr.next != null) {
            curr = curr.next;
            i++;
            if(i > n) nlast = nlast.next;
        }
        return nlast;
    }

}
