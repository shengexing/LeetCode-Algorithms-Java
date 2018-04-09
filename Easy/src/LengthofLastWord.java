/**
 * 	Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 	return the length of last word in the string.
	If the last word does not exist, return 0.
	(����һ���ַ���s�ɴ�д/Сд��ĸ�Ϳհ��ַ����' '�������ַ��������һ�����ʵĳ��ȡ�
	������һ���ֲ����ڣ��򷵻�0��)

	Note: A word is defined as a character sequence consists of non-space characters only.
	(ע�⣺���ʱ�����Ϊֻ�����ǿո��ַ����ַ����С�)

	Example:
	Input: "Hello World"
	Output: 5

 * @author Time
 *
 */
public class LengthofLastWord {
	
	public int lengthOfLastWord_1(String s) {
		return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
	}

	public int lengthOfLastWord_2(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		int len = s.length(), m = len, n = len;
		
		for(int i = len -1; i >= 0; i--)
			if(s.charAt(i) != ' ') {
				m = i; break;
			}
		if(m == len) return 0;
		
		for(int i = m - 1; i >= 0; i--)
			if(s.charAt(i) == ' ') {
				n = i; break;
			}
		if(n == len) return m + 1;
		
		return m - n;
	}

	public static void main(String[] args) {

	}

}