
/**
 * 	Implement strStr().
	Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	(实现 strStr（）。在 haystack 中返回 needle 出现的指数，如果针不是 haystack 的一部分，则返回-1。)

	Example 1:
	Input: haystack = "hello", needle = "ll"
	Output: 2

	Example 2:
	Input: haystack = "aaaaa", needle = "bba"
	Output: -1
 * @author Time
 *
 */
public class ImplementStr {

	public int strStr_1(String haystack, String needle) {
		if(haystack == null || needle == null)
			return -1;

		int len = needle.length(), length = haystack.length();

		if(len == 0)
			return 0;

		for(int i = 0; i <= length - len; i++)
			if(haystack.charAt(i) == needle.charAt(0) && needle.equals(haystack.substring(i, i + len)))
				return i;

		return -1;
	}

	public int strStr_2(String haystack, String needle) {
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == needle.length()) return i;
				if (i + j == haystack.length()) return -1;
				if (needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
	}

	public int strStr_3(String haystack, String needle) {
		int l1 = haystack.length(), l2 = needle.length();

		if (l1 < l2) return -1;
		else if (l2 == 0) return 0;
		
		int threshold = l1 - l2;
		for (int i = 0; i <= threshold; ++i)
			if (haystack.substring(i,i+l2).equals(needle)) return i;
		
		return -1;
	}

	public static void main(String[] args) {
		ImplementStr test = new ImplementStr();
		System.out.println(test.strStr_1("aabbccdd", "bbc"));
	}

}
