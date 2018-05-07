import java.util.Deque;
import java.util.LinkedList;

/**
 * 	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of 
	the two subtrees of every node never differ by more than 1.
	(给定一个元素按升序排列的数组，将其转换为高度平衡的BST。
	对于这个问题，一个高度平衡的二叉树被定义为一个二叉树，其中每个节点的两个子树的深度相差不会超过1。)

	Example:
	Given the sorted array: [-10,-3,0,5,9],
	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

	      0
	     / \
	   -3   9
	   /   /
	 -10  5

 * @author Time
 *
 */
public class ConvertSortedArraytoBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode sortedArrayToBST_1(int[] nums) {
		if(nums == null) return null;
		else if(nums.length == 0) return null;
		TreeNode head = sortedArrayToBSTHelp(nums, 0, nums.length - 1);
		return head;
	}

	public TreeNode sortedArrayToBSTHelp(int[] nums, int low, int high) {
		if (low > high) return null;
		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBSTHelp(nums, low, mid - 1);
		node.right = sortedArrayToBSTHelp(nums, mid + 1, high);
		return node;
	}

	@SuppressWarnings("serial")
	public TreeNode sortedArrayToBST_2(int[] nums) {
		int len = nums.length;
		if (len == 0) return null;

		// 0 as a placeholder
		TreeNode head = new TreeNode(0);

		Deque<TreeNode> nodeStack = new LinkedList<TreeNode>() {{ push(head);}};
		Deque<Integer>  leftIndexStack = new LinkedList<Integer>() {{ push(0);}};
		Deque<Integer>  rightIndexStack = new LinkedList<Integer>() {{ push(len-1);}};

		while (!nodeStack.isEmpty()) {
			TreeNode currNode = nodeStack.pop();
			int left  = leftIndexStack.pop();
			int right = rightIndexStack.pop();
			int mid   = left + (right-left)/2; // avoid overflow
			currNode.val = nums[mid];
			if ( left <= mid - 1 ) {
				currNode.left = new TreeNode(0); 
				nodeStack.push(currNode.left);
				leftIndexStack.push(left);
				rightIndexStack.push(mid-1);
			}
			if ( mid + 1 <= right ) {
				currNode.right = new TreeNode(0);
				nodeStack.push(currNode.right);
				leftIndexStack.push(mid+1);
				rightIndexStack.push(right);
			}
		}
		return head;
	}

	public static void main(String[] args) {
		int[] nums = {-10, -3, 0, 5, 9};
		ConvertSortedArraytoBinarySearchTree test = new ConvertSortedArraytoBinarySearchTree();
		test.sortedArrayToBST_1(nums);

	}

}
