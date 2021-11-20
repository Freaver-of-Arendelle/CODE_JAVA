class Solution {
    public int maxProfit(int[] prices) {
        int min = 10001;
        int max = 0;
        int temp = 0;

        for (int i = 0; i < prices.length; i++) {
            int t = prices[i];
            if (t < min) {
                temp = Math.max(temp, max - min);
                min = t;
                max = 0;
            } else if (t > max){
                max = t;
            }
        }
        temp = Math.max(temp, max - min);
        if (temp > 0) {
            return temp;
        } else {
            return 0;
        }
    }
}
