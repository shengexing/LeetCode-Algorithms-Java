import java.util.Arrays;

/**
 * 	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	You may assume that the array is non-empty and the majority element always exist in the array.
	(给定一个大小为n的数组，找到大多数元素。多数元素是出现次数多的元素⌊ n/2 ⌋。
	你可能会认为数组是非空的，而且大多数元素总是存在于数组中。)

	Example 1:
	Input: [3,2,3]
	Output: 3

	Example 2:
	Input: [2,2,1,1,1,2,2]
	Output: 2

 * @author Time
 *
 */
public class MajorityElement {

	public int majorityElement(int[] nums) {
		if(nums == null) return Integer.MIN_VALUE;
		
		Arrays.sort(nums);
		int len = nums.length, time = len / 2, t = 1;
		if(len == 1) return nums[0];
		for(int i = 0, j; i < nums.length - 1; i++) {
			for (j = i + 1; j < nums.length && nums[i] == nums[j]; j++, t++);
			if(t > time) return nums[i];
			i = j - 1; t = 1;
		}
		
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		MajorityElement test = new MajorityElement();
		int[] nums = {2,2,1,1,1,2,2};
		System.out.println(test.majorityElement(nums));
	}

}
