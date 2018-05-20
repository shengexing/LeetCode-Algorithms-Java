/**
 * 	Given a linked list, determine if it has a cycle in it.
	(给定一个链表，确定它是否有一个循环。)

	Follow up:
	Can you solve it without using extra space?
	(你可以解决它没有使用额外的空间？)

 * @author Time
 *
 */
public class LinkedListCycle {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode p = head,pre = head;
    	while(p != null && p.next != null){
    		if (p.next == head) return true;
    		p = p.next;
    		pre.next = head;
    		pre = p;
    	}
        return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
