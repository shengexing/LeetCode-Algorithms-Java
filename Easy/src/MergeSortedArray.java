/**
 * 	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	(���������������������nums1��nums2����nums2�ϲ�Ϊnums1��Ϊһ���������顣)

	Note:
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional 
	elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
	(�����ܻ���Ϊnums1�����㹻�Ŀռ䣨��С���ڻ����m + n��������nums2�е�����Ԫ�ء�nums1��nums2�г�ʼ����Ԫ�������ֱ�Ϊm��n��)

 * @author Time
 *
 */
public class MergeSortedArray {

	public void merge_1(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while(i >= 0 && j >= 0) {
			if(nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}

		while(j >= 0)
			nums1[k--] = nums2[j--];
	}

	public void merge_2(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, tar = m + n - 1;
		while (j >= 0)
			nums1[tar--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];

	}

	public String printArray(int[] a) {
		String result = "[";
		for(int i = 0; i < a.length; i++) {
			result += a[i] + " ";
		}
		result +="]";
		return result;
	}

	public static void main(String[] args) {
		
	}

}
