/**
 * 	Given a binary tree, determine if it is height-balanced.
	For this problem, a height-balanced binary tree is defined as:
	a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	(给定一个二叉树，确定它是否是高度平衡的。
	对于这个问题，一个高度平衡的二叉树被定义为：一个二叉树，其中每个节点的两个子树的深度不会相差超过1。)

	Example 1:
	Given the following tree [3,9,20,null,null,15,7]:
	    3
	   / \
	  9  20
	    /  \
	   15   7
	Return true.

	Example 2:
	Given the following tree [1,2,2,3,3,null,null,4,4]:
	       1
	      / \
	     2   2
	    / \
	   3   3
	  / \
	 4   4
	Return false.

 * @author Time
 *
 */
public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isBalanced_1(TreeNode root) {
		if(root == null) return true;

		long l = getTreeHeight(root.left), r = getTreeHeight(root.right), m = l > r ? (l - r) : (r - l);

		return isBalanced_1(root.left) && isBalanced_1(root.right) && (m <= 1);

	}

	public long getTreeHeight(TreeNode root) {
		if(root == null) return 0L;
		long l = getTreeHeight(root.left), r = getTreeHeight(root.right);
		return 1L + (l > r ? l : r);

	}
	
	public boolean isBalanced_2(TreeNode root) {
        return dfsHeight(root) != -1;
    }
	
	public int dfsHeight (TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
