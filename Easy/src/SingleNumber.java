/**
 * 	Given a non-empty array of integers, every element appears twice except for one. Find that single one.
	(����һ���ǿ�  �������飬����һ��Ԫ���⣬ÿ��Ԫ�ض���������Ρ��ҵ���һ����)
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	(�����㷨Ӧ�þ�����������ʱ�����ԡ������ʵ����������ʹ�ö�����ڴ棿)

	Example 1:
	Input: [2,2,1]
	Output: 1

	Example 2:
	Input: [4,1,2,1,2]
	Output: 4

 * @author Time
 *
 */
public class SingleNumber {

	public int singleNumber_1(int[] nums) {
		int res = 0;
        for(int x: nums) res ^= x;
        return res;
	}

	public static void main(String[] args) {
		SingleNumber test = new SingleNumber();
		int[] nums = {4, 2, 1, 2, 1};
		System.out.println(test.singleNumber_1(nums));

	}

}
