/**
 * 	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
	(在数组中找到连续的子数组（至少包含一个数字），这个数组的总和最大。
	例如，给定数组[-2,1，-3,4，-1,2,1，-5,4]，连续的子数组[4，-1,2,1]具有最大的和= 6。)

	More practice:
	If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, 
	which is more subtle.
	()
 * @author Time
 *
 */
public class MaximumSubarray {

	public int maxSubArray_1(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];	//dp[i] means the maximum subarray ending with A[i];
		dp[0] = nums[0];
		int max = dp[0];

		for(int i = 1; i < n; i++){
			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
	
	public int maxSubArray_2(int[] nums) {
	    int maxSoFar=nums[0], maxEndingHere=nums[0];
	    
	    for (int i = 1; i < nums.length; ++i){
	    	maxEndingHere = Math.max(maxEndingHere+nums[i],nums[i]);
	    	maxSoFar = Math.max(maxSoFar, maxEndingHere);
	    }
	    
	    return maxSoFar;
	}

	public static void main(String[] args) {

	}

}
