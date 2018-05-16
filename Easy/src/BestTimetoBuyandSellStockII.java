/**
 * 	Say you have an array for which the ith element is the price of a given stock on day i.
	Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
	(i.e., buy one and sell one share of the stock multiple times).	
	(��������һ�����飬���е�i ��Ԫ���ǵ�i�������Ʊ�ļ۸����һ���㷨���ҵ��������������Ը�����Ҫ��ɾ����ܶ�Ľ���
	����������������һ�ι�Ʊ����)

	Note: You may not engage in multiple transactions at the same time 
	(i.e., you must sell the stock before you buy again).
	(ע�⣺������ͬʱ���ж�ʽ���
	�������������ٴι���֮ǰ���۹�Ʊ����)

	Example 1:
	Input: [7,1,5,3,6,4]
	Output: 7
	Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
	             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
	(�ڵ�2�����루�۸�= 1�����ڵ�3���������۸�= 5��������= 5-1 = 4��
             Ȼ���ڵ�4�칺�򣨼۸�= 3�����ڵ�5���������۸�= 6��������= 6-3 = 3��)

	Example 2:
	Input: [1,2,3,4,5]
	Output: 4
	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
	             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
	             engaging multiple transactions at the same time. You must sell before buying again.
	(��1�죨�۸�= 1�����룬��5���������۸�= 5��������= 5-1 = 4��
             ��ע�⣬�������ڵ�1�칺���ڵ�2�칺���Ժ�������������һ��
             ͬʱ�����ʽ��ס���������ٴι���֮ǰ���ۡ�)

	Example 3:
	Input: [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transaction is done, i.e. max profit = 0.
	(����������£�û�н�����ɣ����������= 0��)

 * @author Time
 *
 */
public class BestTimetoBuyandSellStockII {

	public int maxProfit_1(int[] prices) {
		int total = 0;

		for (int i = 0; i< prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) total += prices[i + 1] - prices[i];
		}

		return total;
	}

	public int maxProfit_2(int[] prices) {
		int profit = 0;
		int n , mini = 0;
		int buy = 0;
		int sell = 0;
		n = prices.length;
		boolean flag1 = false; //buy
		boolean flag2 = true; //sell
		
		for(int i = 0; i < n - 1; i++) {
			if(n > 2) {
				if((prices[i + 1] > prices[i] && flag2 == true)||(prices[i + 1] > prices[i] && flag1 == true && i + 1 == n - 1)) {
					if(prices[i + 1] > prices[i] && flag2 == true) { buy = i; flag1 = true; flag2 = false; }
					if(prices[i + 1] > prices[i] && flag1 == true && i + 1 == n - 1) { sell = i + 1; flag2 = true; }
					else continue;
				}
				
				if(prices[i + 1] <= prices[i] && flag1 == true) {
					sell = i; flag2 = true;
				}

				if(prices[sell] - prices[buy] > 0 && flag1 == true && flag2 == true) {
					profit += prices[sell] - prices[buy];
					flag1 = false;
					flag2 = true;
					prices[sell] = 0;
					prices[buy] = 0;
				}
			}
			
			if(n == 2) {
				if(prices[i + 1] > prices[i] && flag2 == true) {
					buy = i;
					sell = i + 1;
					profit = prices[sell] - prices[buy];
				}
			}
		}
		
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
