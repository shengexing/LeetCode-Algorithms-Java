import java.util.LinkedList;
import java.util.List;

/**
 * 	Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
	Note that the row index starts from 0.
	(给定一个非负指数k其中k≤33，返回k个帕斯卡三角的索引行。
	请注意，行索引从0开始。)

	In Pascal's triangle, each number is the sum of the two numbers directly above it.
	(在帕斯卡的三角形中，每个数字都是直接在它上面的两个数字的总和。)

	Example:
	Input: 3
	Output: [1,3,3,1]

	Follow up:
	Could you optimize your algorithm to use only O(k) extra space?
	(你能优化你的算法只使用O（k）额外的空间吗？)

 * @author Time
 *
 */
public class PascalsTriangleII {
	
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new LinkedList<>();
		
		if(rowIndex >= 0) {
			result.add(1);
			for(int i = 1; i < rowIndex + 1; i++) {
				int size = result.size();
				result.add(1);
				for(int j = 1, last = result.get(j - 1); j < size; j++) {
					int now = result.get(j);
					result.set(j, last + now);
					last = now;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
