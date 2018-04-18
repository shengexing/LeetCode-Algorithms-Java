/**
 * 	You are climbing a stair case. It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	(你正在爬楼梯的情况。需要n个步骤才能到达顶端。
	每次你可以爬1或2步。有多少种不同的方式可以爬到顶端？)

	Note: Given n will be a positive integer.
	(注意：给定n将是一个正整数。)

	Example 1:
	Input: 2
	Output:  2

	Explanation:  There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 steps

	Example 2:
	Input: 3
	Output:  3

	Explanation:  There are three ways to climb to the top.
	1. 1 step + 1 step + 1 step
	2. 1 step + 2 steps
	3. 2 steps + 1 step

 * @author Time
 *
 */
public class ClimbingStairs {

	public int climbStairs_1(int n) {
		// base cases
	    if(n <= 0) return 0;
	    if(n == 1) return 1;
	    if(n == 2) return 2;
	    
	    int one_step_before = 2;
	    int two_steps_before = 1;
	    int all_ways = 0;
	    
	    for(int i = 2; i < n; i++){
	    	all_ways = one_step_before + two_steps_before;
	    	two_steps_before = one_step_before;
	        one_step_before = all_ways;
	    }
	    
	    return all_ways;
	}
	
	public int climbStairs_2(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }

	public static void main(String[] args) {
		ClimbingStairs test = new ClimbingStairs();
		System.out.println(test.climbStairs_1(5) + ", " + test.climbStairs_2(5));

	}

}
