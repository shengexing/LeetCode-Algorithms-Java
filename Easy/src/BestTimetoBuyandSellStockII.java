/**
 * 	Say you have an array for which the ith element is the price of a given stock on day i.
	Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
	(i.e., buy one and sell one share of the stock multiple times).	
	(假设你有一个数组，其中第i 个元素是第i天给定股票的价格。设计一个算法来找到最大的利润。您可以根据需要完成尽可能多的交易
	（即多次买入和卖出一次股票）。)

	Note: You may not engage in multiple transactions at the same time 
	(i.e., you must sell the stock before you buy again).
	(注意：您不得同时进行多笔交易
	（即您必须在再次购买之前出售股票）。)

	Example 1:
	Input: [7,1,5,3,6,4]
	Output: 7
	Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
	             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
	(在第2天买入（价格= 1）并在第3天卖出（价格= 5），利润= 5-1 = 4。
             然后在第4天购买（价格= 3）并在第5天卖出（价格= 6），利润= 6-3 = 3。)

	Example 2:
	Input: [1,2,3,4,5]
	Output: 4
	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
	             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
	             engaging multiple transactions at the same time. You must sell before buying again.
	(第1天（价格= 1）买入，第5天卖出（价格= 5），利润= 5-1 = 4。
             请注意，您不能在第1天购买，在第2天购买并稍后卖出，就像您一样
             同时参与多笔交易。你必须在再次购买之前出售。)

	Example 3:
	Input: [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transaction is done, i.e. max profit = 0.
	(在这种情况下，没有交易完成，即最大利润= 0。)

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
