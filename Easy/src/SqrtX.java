/**
 * 	Implement int sqrt(int x).
	Compute and return the square root of x.
	x is guaranteed to be a non-negative integer.


	Example 1:
	Input: 4
	Output: 2

	Example 2:
	Input: 8
	Output: 2
	Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.

 * @author Time
 *
 */
public class SqrtX {

	public int mySqrt(int x) {
		if(x < 0) return -1;
		
		long i = 0;
		while(i * i <= x) i++;
		
		return (int)--i;
	}

	public static void main(String[] args) {
		SqrtX test = new SqrtX();
		System.out.println(test.mySqrt(2147395600));

	}

}
