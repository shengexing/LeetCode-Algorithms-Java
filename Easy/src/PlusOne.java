/**
 * 	Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
	You may assume the integer do not contain any leading zero, except the number 0 itself.
	The digits are stored such that the most significant digit is at the head of the list.
	(����һ����ʾΪ�ǿ���������ķǸ��������ټ���һ��������
	�����Լ���������������κ�ǰ���㣬��������0������
	���ֱ��洢Ϊʹ�������Ч����λ���б���ͷ����)
	
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