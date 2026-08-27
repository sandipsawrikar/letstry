package leetcode;

import java.util.Arrays;

public class MaxProfit {
    public static void main(String[] args) {
       int [] result = maxProfit(new int[]{1,6,3,13,10,13});
       System.out.println(result[0]+"- "+result[1]);

    }

    private static int[] maxProfit(int[] prices) {
        int  [] result = new int[2];
        int buy = prices[0];
        int profit = 0;
        for (int i=1; i<prices.length; i++){
          if( prices[i] < buy)
              buy = prices[i];
          else if(prices[i] - buy > profit){
            profit = prices[i] - buy;
          }
        }
        result[0]=buy;
        result[1]=profit;
        return result;
    }
}
