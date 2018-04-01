/**
 * 	Given a sorted array and a target value, return the index if the target is found. 
 	If not, return the index where it would be if it were inserted in order.
	You may assume no duplicates in the array.
	(����һ�����������Ŀ��ֵ������ҵ�Ŀ�꣬�򷵻������� ���û�У��򷵻�������������ǰ�˳�����Ļ�������ܻ���Ϊû���ظ������顣)

	Example 1:
	Input: [1,3,5,6], 5
	Output: 2

	Example 2:
	Input: [1,3,5,6], 2
	Output: 1

	Example 3:
	Input: [1,3,5,6], 7
	Output: 4

	Example 1:
	Input: [1,3,5,6], 0
	Output: 0
 * @author Time
 *
 */
public class SearchInsertPosition {

	public int searchInsert_1(int[] nums, int target) {
		int index = 0;
		
		if(nums == null || nums.length == 0) return index;
		
		while(index < nums.length) {
			if(target <= nums[index]) return index;
			index++;
		}
		
		return index;
	}
	
	public int searchInsert_2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        
        return low;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}