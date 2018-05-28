import java.util.Arrays;

/**
 * 	Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
	(�����Ѱ�����������������飬�ҵ��������֣�ʹ���Ǻϼ�Ϊ�ض���Ŀ�����֡�)
	The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
	(����twoSumӦ�÷������������ֵ��������Ա����ǺϼƵ�Ŀ�꣬����index1����С��index2��)

	Note:
	Your returned answers (both index1 and index2) are not zero-based.
	You may assume that each input would have exactly one solution and you may not use the same element twice.
	(�����صĴ𰸣�index1��index2�����Ǵ��㿪ʼ�ġ�
	�����ܻ���Ϊÿ�����붼ֻ��һ��������������������ܲ���ʹ����ͬ��Ԫ�����Ρ�)

	Example:
	Input: numbers = [2,7,11,15], target = 9
	Output: [1,2]
	Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

 * @author Time
 *
 */
public class TwoSumIIInputarrayissorted {

	public int[] twoSum_1(int[] numbers, int target) {
		if(numbers == null || numbers.length < 2) return null;

		int[] result = new int[2];
		for(int i = 0; i < numbers.length - 1; i++) {
			int val = target - numbers[i]; result[0] = i + 1;
			for(int j = i + 1; j < numbers.length && val >= numbers[j]; j++)
				if(val == numbers[j]) { result[1] = j + 1; return result;}
		}

		return null;
	}

	public int[] twoSum_2(int[] numbers, int target) {
		int[] elements = new int[2];
		for(int i = 0;i < numbers.length; i++){
			int targetNum = target-numbers[i];
			elements[0] = i + 1;
			if(binarySearch(numbers,targetNum,elements,i) && elements[0] != elements[1]) break;
			if(binarySearch(numbers,targetNum,elements,i) && elements[0] == elements[1]) continue;
		}
		Arrays.sort(elements);
		return elements;
	}

	public boolean binarySearch(int[] numbers,int targetNum,int[] elements,int i){
		int lo = 0, hi = numbers.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(numbers[mid] == targetNum) {
				elements[1] = mid + 1;
				return true;
			} else if(numbers[mid] > targetNum) hi = mid - 1;
			else lo = mid + 1;
		}
		return false;
	}

	public int[] twoSum_3(int[] numbers, int target) {
		int l = 0, h = numbers.length - 1;
		
		int [] res = new int [2];
		while(h > l) {
			int temp = numbers[h] + numbers[l];
			if(temp == target){
				res[0] = l + 1;
				res[1] = h + 1;
				return res;
			}else if(temp > target) h--;
			else l++;
		}
		return res; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
