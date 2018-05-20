/**
 * 	Write a program to find the node at which the intersection of two singly linked lists begins.
	(编写一个程序来查找两个单独链接列表的交集开始的节点。)

	For example, the following two linked lists:
	A:          a1 → a2
	                   	↘
	                     c1 → c2 → c3
	                   	↗            
	B:     b1 → b2 → b3

	begin to intersect at node c1.
	(开始在节点c1相交。)

	Notes:
	If the two linked lists have no intersection at all, return null.
	The linked lists must retain their original structure after the function returns.
	You may assume there are no cycles anywhere in the entire linked structure.
	Your code should preferably run in O(n) time and use only O(1) memory.
	(如果两个链表完全没有交集，则返回null。
	链接列表在函数返回后必须保留其原始结构。
	您可能会认为整个链接结构中没有任何地方的循环。
	您的代码应该最好在O（n）时间内运行，并只使用O（1）内存。)

 * @author Time
 *
 */
public class IntersectionofTwoLinkedLists {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
		//boundary check
		if(headA == null || headB == null) return null;

		ListNode a = headA;
		ListNode b = headB;

		//if a & b have different len, then we will stop the loop after second iteration
		while( a != b){
			//for the end of first iteration, we just reset the pointer to the head of another linkedlist
			a = a == null? headB : a.next;
			b = b == null? headA : b.next;    
		}

		return a;
	}

	public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;

		int sizeA = 0, sizeB = 0;
		for(ListNode a = headA; a != null; a = a.next) sizeA++;
		for(ListNode b = headB; b != null; b = b.next) sizeB++;

		ListNode a = headA, b = headB;
		if(sizeA > sizeB)
			for(int i = sizeA - sizeB; i > 0; i --) a = a.next;
		else if(sizeA < sizeB)
			for(int i = sizeB - sizeA; i > 0; i --) b = b.next;

		int commonSize = Math.min(sizeA, sizeB);

		while(commonSize > 0){
			if(a == b) return a;
			else {
				commonSize --;
				a = a.next;
				b = b.next;
			}
		}
		return null;
	}

	public ListNode getIntersectionNode_3(ListNode headA, ListNode headB){
		//双指针方案，拼接链表，利用环的思想
		//Dual-pointer scheme, splicing linked lists, using ring ideas
		if(headA == null || headB == null) return null;
		
		ListNode tempA = headA, tempB = headB;
		int countA = 0, countB = 0;

		while(tempA != tempB){
			if(countA >= 2 && countB >= 2) return null;

			if(tempA.next == null) {
				tempA = headB;
				countA++;
			} else tempA = tempA.next;

			if(tempB.next == null) {
				tempB = headA;
				countB++;
			} else tempB = tempB.next;
		}
		
		return tempA;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
