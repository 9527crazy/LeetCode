package 两两交换链表中的节点;

public class Main {

	public static void main(String[] args) {
		Solution solution=new Solution();
		int[] s= {1,2,3,4};
		ListNode head=new ListNode(s[0]);
		head.next=new ListNode(s[1]);
		head.next.next=new ListNode(s[2]);
		head.next.next.next=new ListNode(s[3]);
		solution.swapPairs(head);
		name(head);
	}
	
	public static int  name(ListNode head) {
		if(head.next==null) {
			System.out.println(head.val);
			return head.val;
		}
		return name(head.next);
	}
}
class Solution {
    public ListNode swapPairs(ListNode head) {
    	if(head==null||head.next==null)
    		return head;
    	ListNode next=head.next;//2
    	head.next=swapPairs(next.next);//1->3
    	next.next=head;//2->1
    	return next;
    }
}

