/**
 * 	Write a program to find the node at which the intersection of two singly linked lists begins.
	(��дһ�������������������������б�Ľ�����ʼ�Ľڵ㡣)

	For example, the following two linked lists:
	A:          a1 �� a2
	                   	�K
	                     c1 �� c2 �� c3
	                   	�J            
	B:     b1 �� b2 �� b3

	begin to intersect at node c1.
	(��ʼ�ڽڵ�c1�ཻ��)

	Notes:
	If the two linked lists have no intersection at all, return null.
	The linked lists must retain their original structure after the function returns.
	You may assume there are no cycles anywhere in the entire linked structure.
	Your code should preferably run in O(n) time and use only O(1) memory.
	(�������������ȫû�н������򷵻�null��
	�����б��ں������غ���뱣����ԭʼ�ṹ��
	�����ܻ���Ϊ�������ӽṹ��û���κεط���ѭ����
	���Ĵ���Ӧ�������O��n��ʱ�������У���ֻʹ��O��1���ڴ档)

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
		//˫ָ�뷽����ƴ���������û���˼��
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
