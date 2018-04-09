/**
 * 	Given two binary strings, return their sum (also a binary string).
	(给定两个二进制字符串，返回它们的和（也是一个二进制字符串）。)

	For example,
	a = "11"
	b = "1"
	Return "100".

 * @author Time
 *
 */
/**
 * @author Time
 *
 */
public class AddBinary {

	public String addBinary_1(String a, String b) {
		String result = "";
		
		int len_a = a.length(), len_b = b.length(), len = (len_a > len_b ? len_a : len_b);
		int c = 0;
		for(int i = len_a; i < len; i++) a = "0" + a;
		for(int i = len_b; i < len; i++) b = "0" + b;
		
		for(int i = 1; i <= len; i++) {
			char a1 = a.charAt(len - i), b1 = b.charAt(len - i);
			if(c == 0) {
				if(a1 == b1 && a1 == '0') {result = "0" + result; c = 0;}
				if(a1 == b1 && a1 == '1') {result = "0" + result; c = 1;}
				if(a1 != b1) {result = "1" + result; c = 0;}
			} else {
				if(a1 == b1 && a1 == '0') {result = "1" + result; c = 0;}
				if(a1 == b1 && a1 == '1') {result = "1" + result; c = 1;}
				if(a1 != b1) {result = "0" + result; c = 1;}
			}
		}
		
		if(c == 1) result = "1" + result;
		
		return result;
	}
	
	public String addBinary_2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		System.out.println(test.addBinary_1("110", "11"));

	}

}
