class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        //put in map count freeq
        for( int num:nums){
         map.put(num,map.getOrDefault(num,0)+1);
        }
        // convert into list to map  for the sorting based on the freq so use coustum sort by lamda functions
        List<Map.Entry<Integer,Integer>> list =new ArrayList<>(map.entrySet());
        
        //  use custom sroting based on freeq
        list.sort((a,b)->b.getValue()-a.getValue());
        
        // ans list create 
        // List<Integer> ans=new ArrayList<>();
        int [] ans=new int[k];
        for(int i=0; i<k;i++){
            ans[i]=list.get(i).getKey();
        }

        
             return ans;         
    }
}
