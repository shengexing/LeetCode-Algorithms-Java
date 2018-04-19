import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 	Given a binary tree, find its maximum depth.
	The maximum depth is the number of nodes along the longest path from the root node down to 
	the farthest leaf node.
	(给定一个二叉树，找到它的最大深度。
	最大深度是从根节点到最远叶节点沿着最长路径的节点数量。)

	For example:
	Given binary tree [3,9,20,null,null,15,7],

	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its depth = 3.

 * @author Time
 *
 */
public class MaximumDepthofBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int maxDepth_1(TreeNode root) {
		if(root == null) return 0;
		int l = maxDepth_1(root.left), r = maxDepth_1(root.right);
		return 1 + (l > r ? l : r);
	}

	//DFS(7ms)
	public int maxDepth_2(TreeNode root) {
		if(root == null) return 0;

		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		
		stack.push(root);
		value.push(1);
		int max = 0;
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int temp = value.pop();
			max = Math.max(temp, max);
			if(node.left != null) {
				stack.push(node.left);
				value.push(temp + 1);
			}
			if(node.right != null) {
				stack.push(node.right);
				value.push(temp + 1);
			}
		}
		
		return max;
	}
	
	//BFS(3ms)
	public int maxDepth_3(TreeNode root) {
	    if(root == null) return 0;
	    
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    int count = 0;
	    
	    while(!queue.isEmpty()) {
	        int size = queue.size();
	        while(size-- > 0) {
	            TreeNode node = queue.poll();
	            if(node.left != null) {
	                queue.offer(node.left);
	            }
	            if(node.right != null) {
	                queue.offer(node.right);
	            }
	        }
	        count++;
	    }
	    
	    return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
