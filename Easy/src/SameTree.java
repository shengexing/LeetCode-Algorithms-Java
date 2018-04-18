import java.util.Stack;

/**
 * 	Given two binary trees, write a function to check if they are the same or not.
	Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
	(给定两个二叉树，写一个函数来检查它们是否相同。
	如果两棵树在结构上相同并且节点具有相同的值，则认为它们是相同的。)

	Example 1:
	Input:     1         1
	          / \       / \
	         2   3     2   3

	        [1,2,3],   [1,2,3]
	Output: true

	Example 2:
	Input:     1         1
	          /           \
	         2             2

	        [1,2],     [1,null,2]

	Output: false

	Example 3:
	Input:     1         1
	          / \       / \
	         2   1     1   2

	        [1,2,1],   [1,1,2]
	Output: false

 * @author Time
 *
 */
public class SameTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isSameTree_1(TreeNode p, TreeNode q) {
		if(p == null) {
			if(q == null) return true;
			else return false;
		} else {
			if(q == null) return false;
			else return p.val == q.val && isSameTree_1(p.left, q.left) && isSameTree_1(p.right, q.right);
		}
	}

	public boolean isSameTree_2(TreeNode p, TreeNode q) {
		if(p == null || q == null) return p == q;
		else return p.val == q.val && isSameTree_2(p.left, q.left) && isSameTree_2(p.right, q.right);

	}

	public boolean isSameTree_3(TreeNode p, TreeNode q) {
		Stack<TreeNode> stack_p = new Stack <> ();       
		Stack<TreeNode> stack_q = new Stack <> ();
		if (p != null) stack_p.push( p ) ;
		if (q != null) stack_q.push( q ) ;
		while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
			TreeNode pn = stack_p.pop() ;
			TreeNode qn = stack_q.pop() ;	    	
			if (pn.val != qn.val) return false ;
			if (pn.right != null) stack_p.push(pn.right) ;
			if (qn.right != null) stack_q.push(qn.right) ;
			if (stack_p.size() != stack_q.size()) return false ;
			if (pn.left != null) stack_p.push(pn.left) ;	    	 	    	 
			if (qn.left != null) stack_q.push(qn.left) ;
			if (stack_p.size() != stack_q.size()) return false ;
		}		     
		return stack_p.size() == stack_q.size() ;	 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
