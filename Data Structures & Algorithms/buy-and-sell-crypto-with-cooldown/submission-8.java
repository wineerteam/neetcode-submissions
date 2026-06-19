class Solution {
    
int dp[][]=new int [5000+1][2];
    public int maxProfit(int[] price) {
        for( int i=0; i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=price.length;
        return solve( price, 0,n-1,1);
    }

    int solve(int price[], int day, int n, int buy){
        if( day > n) return 0;
         
        // if already calculated 
        if( dp[day][buy] != -1) return dp[day][buy];

        int profit=0;
        // first day to buy karna hi hoga.tabhi to hum future me sell kr skte h
        if( buy==1){
              /// buy kr liye to sell ko call kr ke profit find krna h.
            int take = solve(price,day+1,n,0 )-price[day];
            
            

            // abhi buy nhi kiye to buy ko hi call karna hoga. tabhi to sell krenge future
            int non_take=solve(price,day+1,n,1);
            profit = Math.max(profit,Math.max(take,non_take));
        }
        else{
            // else hi to sell ki hi bate hongi 
            // sell ko take kar rhe h to fir buy ko call kr lenge but cooldown conditions ke sath
            int take=price[day]+solve(price,day+2,n,1);

            // agar sell nhi kiye to future me sell karna h. to sell ko hi call kar lenge
            int non_take=solve(price,day+1,n,0);

            // find max
            profit=Math.max(profit,Math.max(take,non_take));
        }
        return dp[day][buy]=profit;
    }
}
