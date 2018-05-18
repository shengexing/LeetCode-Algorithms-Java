/**
 * 	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	(给定一个字符串，确定它是否是回文，只考虑字母数字字符并忽略情况。)
	Note: For the purpose of this problem, we define empty string as valid palindrome.
	(注意：  出于此问题的目的，我们将空字符串定义为有效回文。)

	Example 1:
	Input: "A man, a plan, a canal: Panama"
	Output: true

	Example 2:
	Input: "race a car"
	Output: false

 * @author Time
 *
 */
public class ValidPalindrome {

	public boolean isPalindrome_1(String s) {
		if(s == null) return false;
		if(s.length() < 2) return true;
		
		int left = 0, right = s.length() - 1;
		while(left <= right) {
			char l = s.charAt(left), r = s.charAt(right);
			if(l < '0' || (l > '9' && l < 'A') || (l > 'Z' && l < 'a') || l > 'z') { left++; continue; }
			if(r < '0' || (r > '9' && r < 'A') || (r > 'Z' && r < 'a') || r > 'z') { right--; continue; }
			if(!isSame(l, r)) return false;
			left++; right--;
		}
		
		return true;
	}
	
	public boolean isSame(char l, char r) {
		if((l >= 'A' && l <= 'Z') || (l >= 'a' && l <= 'z')) {
			if((r >= 'A' && r <= 'Z') || (r >= 'a' && r <= 'z')) return r == l || r + 32 == l || r - 32 == l;
			else return false;
		} else return l == r;
	}
	
	public boolean isPalindrome_2(String s) {
        if(s == null || s.length() == 0) 
            return true;
        
        for(int i = 0, j = s.length() - 1; i <= s.length() / 2; i++, j--){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                j++;
                continue;
            }else if(!Character.isLetterOrDigit(s.charAt(j))){
                i--;
                continue;
            }else if(Character.toLowerCase(s.charAt(i))!= Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		ValidPalindrome test = new ValidPalindrome();
		System.out.println(test.isPalindrome_1("A man, a plan, a canal: Panama"));
	}

}
