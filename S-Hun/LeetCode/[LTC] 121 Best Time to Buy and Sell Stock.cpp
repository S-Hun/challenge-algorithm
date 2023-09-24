class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max_price = prices[0], min_price = prices[0], sz = prices.size();
        int max_diff = 0;
        for(int i=1; i<sz; i++) {
            if(max_price < prices[i]) max_price = prices[i];
            if(min_price > prices[i]) 
            {
                if(max_diff < max_price - min_price) max_diff = max_price - min_price;
                max_price = min_price = prices[i];
            }
        }

        if(max_diff < max_price - min_price) max_diff = max_price - min_price;
                
        return max_diff;
    }
};