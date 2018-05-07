/**
 * 	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding 
	up all the values along the path equals the given sum.
	(给定一棵二叉树和一个和，确定树是否有根到叶的路径，这样沿路径加起来的所有值就等于给定的总和。)
	Note: A leaf is a node with no children.
	(注意：  叶子是没有孩子的节点。)

	Example:
	Given the below binary tree and sum = 22,
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \      \
	7    2      1
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author Time
 *
 */
public class PathSum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean hasPathSum_1(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null) return sum == root.val;
		return hasPathSum_1(root.left, sum - root.val) || hasPathSum_1(root.right, sum - root.val);
	}
	
	public TreeNode initTreeNode() {
		TreeNode head = new TreeNode(5);
		head.left = new TreeNode(4);
		head.right = new TreeNode(8);
		head.left.left = new TreeNode(11);
		head.right.left = new TreeNode(13);
		head.right.right = new TreeNode(4);
		head.left.left.left = new TreeNode(7);
		head.left.left.right = new TreeNode(2);
		head.right.right.right = new TreeNode(1);
		return head;
	}

	public static void main(String[] args) {
		PathSum test = new PathSum();
		TreeNode root = test.initTreeNode();
		test.hasPathSum_1(root, 22);

	}

}
