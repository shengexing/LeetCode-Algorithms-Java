import java.util.LinkedList;
import java.util.Queue;

/**
 * 	Given a binary tree, find its minimum depth.
	The minimum depth is the number of nodes along the shortest path from the root node down 
	to the nearest leaf node.
	(给定一个二叉树，找到它的最小深度。
	最小深度是沿着从根节点到最近叶节点的最短路径的节点数量。)

	Note: A leaf is a node with no children.

	Example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its minimum depth = 2.

 * @author Time
 *
 */
public class MinimumDepthofBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int minDepth_1(TreeNode root) {
		if(root == null) return 0;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int height = 1, size = 1;
		while(size-- > 0) {
			TreeNode node = queue.poll();
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);

			if(node.left == null && node.right == null) return height;
			if(size == 0) { height++; size = queue.size();}
		}

		return height;
	}

	public int minDepth_2(TreeNode root) {
		if(root == null) return 0;
		int left = minDepth_2(root.left);
		int right = minDepth_2(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left,right) + 1;

	}

	public int minDepth_3(TreeNode root) {
		if (root == null)
			return 0;
		int depth = 1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode temp, magic = new TreeNode(0);
		queue.add(root);
		queue.add(magic);
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp.equals(magic)){
				if(!queue.isEmpty()){
					depth++;
					queue.add(magic);
				}
				continue;
			}
			if(temp.left == null && temp.right == null)
				return depth;
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
		return depth;
	}

	public TreeNode initTreeNode_1() {
		TreeNode head = new TreeNode(3);
		head.left = new TreeNode(9);
		head.right = new TreeNode(20);
		head.right.left = new TreeNode(15);
		head.right.right = new TreeNode(7);
		return head;
	}

	public TreeNode initTreeNode_2() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.left.left = new TreeNode(3);
		head.left.left.left = new TreeNode(4);
		head.left.left.left.left = new TreeNode(5);
		return head;
	}

	public static void main(String[] args) {
		MinimumDepthofBinaryTree test = new MinimumDepthofBinaryTree();

		TreeNode root = test.initTreeNode_2();

		System.out.println(test.minDepth_1(root));

	}

}
