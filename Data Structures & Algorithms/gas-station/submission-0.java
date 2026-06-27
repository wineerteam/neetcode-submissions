class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int ind=0;
        int total=0,diff=0;

         for( int i=0; i<n; i++){
             ///ye h. total calculate agar -ve to not possible
             diff +=(gas[i]-cost[i]);
            // ye h. ki andar me if condition ke liye 
             total +=(gas[i]-cost[i]);
            if( total <0){
                total=0;
                ind=i+1;
            }
         }
        //  if( diff<0) return -1;
          return (diff<0)?-1:ind;
    }
}