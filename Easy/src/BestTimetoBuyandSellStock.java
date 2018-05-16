/**
 * 	Say you have an array for which the ith element is the price of a given stock on day i.
	(��������һ�����飬���е�i��Ԫ���ǵ�i�������Ʊ�ļ۸�)

	If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
	Note that you cannot sell a stock before you buy one.
	(�����ֻ�����������һ�ʽ��ף�������һֻ��Ʊ������һֻ��Ʊ���������һ���㷨���ҵ��������
	��ע�⣬�ڹ����Ʊ֮ǰ�����޷����۹�Ʊ��)

	Example 1:	
	Input: [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	             Not 7-1 = 6, as selling price needs to be larger than buying price.
	             (��2�죨�۸�= 1�����룬��5���������۸�= 6��������= 6-1 = 5������7-1 = 6����Ϊ���ۼ۸���Ҫ���ڹ���۸�)

	Example 2:
	Input: [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transaction is done, i.e. max profit = 0.
	(����������£�û�н�����ɣ����������= 0��)

 * @author Time
 *
 */
public class BestTimetoBuyandSellStock {

	public int maxProfit_1(int[] prices) {
		if(prices == null || prices.length < 2) return 0;

		int length = prices.length, max = 0;
		for(int i = 0; i < length - 1; i++)
			for(int j = length - 1; j > i; j--) {
				int valj = prices[j], vali = prices[i];
				if(valj > vali) max = Math.max(max, valj - vali);
			}

		return max;
	}

	public int maxProfit_2(int[] prices) {
		int max = 0;
		for(int i = 0; i < prices.length; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				int temp = prices[j] - prices[i];
				if(temp>max) max=temp;
			}
		}
		return max;   
	}

	public int maxProfit_3(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
	
	public int maxProfit_4(int[] prices) {
		if (prices.length == 0) return 0;

		int curr_min = prices[0], max = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {

			max = Math.max(max, prices[i] - curr_min);
			curr_min = Math.min(curr_min, prices[i]);

		}
		return max > 0 ? max : 0;
	}
	
	public static void main(String[] args) {
		BestTimetoBuyandSellStock test = new BestTimetoBuyandSellStock();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(test.maxProfit_1(prices));
	}

}
