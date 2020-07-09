package 反转链表;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] s = { 1, 2, 3, 4, 5 };
		ListNode head = new ListNode(s[0]);
		head.next = new ListNode(s[1]);
		head.next.next = new ListNode(s[2]);
		head.next.next.next = new ListNode(s[3]);
		head.next.next.next.next = new ListNode(s[4]);
		ListNode next = solution.reverseList(head);
		name(next);
	}

	public static int name(ListNode head) {
		if (head.next == null) {
			System.out.println(head.val);
			return head.val;
		}
		return name(head.next);
	}
}

class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode ret = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return ret;
    }
}