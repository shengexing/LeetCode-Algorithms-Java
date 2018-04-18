/**
 * 	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	(给定两个排序的整数数组nums1和nums2，将nums2合并为nums1作为一个排序数组。)

	Note:
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional 
	elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
	(您可能会认为nums1具有足够的空间（大小大于或等于m + n）来容纳nums2中的其他元素。nums1和nums2中初始化的元素数量分别为m和n。)

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
