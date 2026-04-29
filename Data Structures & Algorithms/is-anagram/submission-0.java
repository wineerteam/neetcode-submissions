class Solution {
    public boolean isAnagram(String s, String t) {
    Map<Character,Integer> map=new HashMap<>();
     if( s.length()  != t.length()) return false;
    // both store the value then comapre count 
    for( int i=0; i<s.length(); i++){
        char ch1 =s.charAt(i);
        char ch2 =t.charAt(i);
        map.put(ch1, map.getOrDefault(ch1, 0) + 1);
        map.put(ch2, map.getOrDefault(ch2, 0) - 1);
    }
    for (int freq : map.values()) {
    if (freq != 0) {
       return false;
    }
   
    }
    return true; 

}
}
// Btute forces 
// we  take a map and enter and one take +1 same digit ke liye and other take -1 same digit ke liye





