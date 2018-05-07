import java.util.LinkedList;
import java.util.List;

/**
 * 	Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
	In Pascal's triangle, each number is the sum of the two numbers directly above it.
	(给定一个非负整数  numRows，生成帕斯卡三角形的第一个numRows。
	在帕斯卡的三角形中，每个数字都是直接在它上面的两个数字的总和。)

	Example:
	Input: 5
	Output:
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]

 * @author Time
 *
 */
public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new LinkedList<>();
		
		for(int i = 0; i < numRows; i++) {
			List<Integer> num = new LinkedList<>();
			if(i == 0) num.add(1);
			else {
				List<Integer> temp = result.get(i - 1);
				for (int j = 0; j < i + 1; j++) {
					if(j == 0 || j == i) num.add(1);
					else num.add(temp.get(j - 1) + temp.get(j));
				}
			}
			result.add(num);
		}
		
		return result;
	}

	public static void main(String[] args) {
		
	}

}
