import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 	Given a binary tree, return the bottom-up level order traversal of its nodes' values.
  	(给定一个二叉树，返回其节点值的自底向上的级别遍历。（即从左到右，从叶到根逐级）。)
 	(ie, from left to right, level by level from leaf to root).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its bottom-up level order traversal as:
	[
	  [15,7],
	  [9,20],
	  [3]
	]

 * @author Time
 *
 */

public class BinaryTreeLevelOrderTraversalII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<List<Integer>> levelOrderBottom_1(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();

		if(root == null) return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new LinkedList<>();
			while(size-- > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			result.add(0, list);
		}

		return result;
	}

	//DFS solution:
	public List<List<Integer>> levelOrderBottom_2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

		if(root == null) return wrapList;

		queue.offer(root);
		while(!queue.isEmpty()){
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for(int i=0; i<levelNum; i++) {
				if(queue.peek().left != null) queue.offer(queue.peek().left);
				if(queue.peek().right != null) queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(0, subList);
		}
		return wrapList;
	}

	//BFS solution:
	public List<List<Integer>> levelOrderBottom_3(TreeNode root) {
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		levelMaker(wrapList, root, 0);
		return wrapList;
	}

	public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
		if(root == null) return;
		if(level >= list.size()) {
			list.add(0, new LinkedList<Integer>());
		}
		levelMaker(list, root.left, level+1);
		levelMaker(list, root.right, level+1);
		list.get(list.size()-level-1).add(root.val);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
