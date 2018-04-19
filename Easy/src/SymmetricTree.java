import java.util.Stack;

/**
 * 	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	(给定一个二叉树，检查它是否是它自己的镜像（即围绕它的中心对称）。)

	For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3

	But the following [1,2,2,null,3,null,3] is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3

	Note:
	Bonus points if you could solve it both recursively and iteratively.
	(如果你可以递归地和迭代地解决它，奖励点。)

 * @author Time
 *
 */
public class SymmetricTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isSymmetric_1(TreeNode root) {
		if(root == null) return true;

		TreeNode left = root.left, right = root.right;
		String l = readTreeFromLeft(left), r = readTreeFromRight(right);

		return l.equals(r);
	}

	public String readTreeFromLeft(TreeNode root) {
		if(root == null) return "n";
		else {
			if(root.left != null || root.right != null) return root.val + readTreeFromLeft(root.left) + readTreeFromLeft(root.right);
			else return "" + root.val;
		}
	}

	public String readTreeFromRight(TreeNode root) {
		if(root == null) return "n";
		else {
			if(root.left != null || root.right != null) return root.val + readTreeFromRight(root.right) + readTreeFromRight(root.left);
			else return "" + root.val;
		}
	}

	//Recursive–400ms:
	public boolean isSymmetric_2(TreeNode root) {
		return root == null || isSymmetricHelp(root.left, root.right);
	}

	private boolean isSymmetricHelp(TreeNode left, TreeNode right){
		if(left==null || right==null)
			return left == right;
		if(left.val != right.val)
			return false;
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}

	//Non-recursive(use Stack)–460ms:
	public boolean isSymmetric(TreeNode root) {
		if(root == null)  return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left, right;
		if(root.left != null){
			if(root.right == null) return false;
			stack.push(root.left);
			stack.push(root.right);
		}
		else if(root.right != null){
			return false;
		}

		while(!stack.empty()){
			if(stack.size() % 2 != 0) return false;
			right = stack.pop();
			left = stack.pop();
			if(right.val != left.val) return false;

			if(left.left != null){
				if(right.right == null) return false;
				stack.push(left.left);
				stack.push(right.right);
			}
			else if(right.right != null){
				return false;
			}

			if(left.right != null){
				if(right.left==null) return false;
				stack.push(left.right);
				stack.push(right.left);
			}
			else if(right.left != null){
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

	}

}
