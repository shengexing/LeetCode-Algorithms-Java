/**
 * 	Given a sorted linked list, delete all duplicates such that each element appear only once.
	(给定一个排序链表，删除所有重复项，以便每个元素只出现一次。)

	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.

 * @author Time
 *
 */
public class RemoveDuplicatesfromSortedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode deleteDuplicates_1(ListNode head) {
		ListNode before, now;

		if(head != null) before = head;
		else return head;

		if(head.next != null) now = head.next;
		else return head;


		while(now != null) {
			if(now.val != before.val) before = before.next;
			else before.next = now.next;

			now = now.next;
		}

		return head;
	}

	public ListNode deleteDuplicates_2(ListNode head) {
		if(head == null || head.next == null) return head;
		head.next = deleteDuplicates_2(head.next);
		return head.val == head.next.val ? head.next : head;
	}

	public ListNode deleteDuplicates_3(ListNode head) {
		ListNode list = head;

		while(list != null) {
			if (list.next == null) {
				break;
			}
			if (list.val == list.next.val) {
				list.next = list.next.next;
			} else {
				list = list.next;
			}
		}

		return head;
	}

	public ListNode initList(int[] value) {
		if(value == null || value.length == 0) return null;

		int len = value.length;
		ListNode head = new ListNode(value[0]);
		ListNode before = head;

		for(int i = 1; i < len; i++) {
			ListNode now = new ListNode(value[i]);
			before.next = now;
			before = now;
			now = now.next;
		}

		return head;
	}

	public String printList(ListNode head) {
		String str = "List: ";

		ListNode now = head;
		while(now != null) {
			str += now.val;
			str += " ";
			now = now.next;
		}

		return str;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList test = new RemoveDuplicatesfromSortedList();
		int[] value = {1, 1, 1, 2, 2, 3, 4, 4, 5};
		ListNode head = test.initList(value);
		System.out.println(test.printList(head));
		System.out.println(test.printList(test.deleteDuplicates_1(head)));
	}

}
