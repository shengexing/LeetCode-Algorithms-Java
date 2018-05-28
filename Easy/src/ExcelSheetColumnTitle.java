/**
 * 	Given a positive integer, return its corresponding column title as appear in an Excel sheet.
	(给定一个正整数，返回它在Excel工作表中出现的相应的列标题。)

	For example:
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
	    ...

	Example 1:
	Input: 1
	Output: "A"

	Example 2:
	Input: 28
	Output: "AB"

	Example 3:
	Input: 701
	Output: "ZY"

 * @author Time
 *
 */
public class ExcelSheetColumnTitle {
	
	String[] title = {"#", "A", "B", "C", "D", 
			  "E", "F", "G", "H", "I", 
			  "J", "K", "L", "M", "N", 
			  "O", "P", "Q", "R", "S", 
			  "T", "U", "V", "W", "X", 
			  "Y", "Z"};

	public String convertToTitle_1(int n) {
		if(n < 1) return null;
		if(n < 27) return title[n];
		
		int m = n, c = n;
		if(n > 26) {
			m /= 26; c %= 26;
		}
		if(c == 0) {m -= 1; c = 26;}
		
		return convertToTitle_1(m) + title[c];
	}

	public String convertToTitle_2(int n) {
        StringBuilder result = new StringBuilder();
        
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        
        return result.toString();
    }
	
	public String convertToTitle_3(int n) {
		return n == 0 ? null : convertToTitle_3(--n / 26) + (char)('A' + (n % 26));
	}
	
	public static void main(String[] args) {
		ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
		for(int i = 1; i < 100; i++) {
			if(i % 20 == 0) System.out.println();
			System.out.println(i + ": " + test.convertToTitle_1(i));
		}

	}

}
