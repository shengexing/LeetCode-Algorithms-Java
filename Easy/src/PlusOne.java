/**
 * 	Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
	You may assume the integer do not contain any leading zero, except the number 0 itself.
	The digits are stored such that the most significant digit is at the head of the list.
	(给定一个表示为非空数字数组的非负整数，再加上一个整数。
	您可以假设该整数不包含任何前导零，除了数字0本身。
	数字被存储为使得最高有效数字位于列表的头部。)
	
 * @author Time
 *
 */
public class PlusOne {
	
	public int[] plusOne_1(int[] digits) {
		int len = digits.length, i = len - 1;
		int[] c = new int[len];
		if(digits[i] == 9) {
			digits[i] = 0; c[i] = 1; i--;
		} else {
			digits[i]++; return digits;
		}
			
		while(i >= 0) {
			if(c[i + 1] == 1) {
				if(digits[i] == 9) {digits[i] = 0; c[i] = 1;}
				else {digits[i]++; break;}
				i--;
			}
		}
		
		if(i < 0) {
			int[] result = new int[len + 1];
			result[0] = 1;
			return result;
		}
		
		return digits;
    }
	
	public int[] plusOne_2(int[] digits) {
	    int n = digits.length;
	    
	    for(int i = n - 1; i >= 0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
