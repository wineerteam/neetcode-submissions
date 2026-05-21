class Solution {

    public String minWindow(String s, String t) {

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        // store frequency of t
        for (char ch : t.toCharArray()) {
            mapT[ch]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // sliding window
        for (int right = 0; right < s.length(); right++) {

            mapS[s.charAt(right)]++;

            // valid window
            while (contains(mapS, mapT)) {

                // update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // shrink window
                mapS[s.charAt(left)]--;
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLen);
    }

    // check if current window contains all chars
    public boolean contains(int[] mapS, int[] mapT) {

        for (int i = 0; i < 256; i++) {

            if (mapT[i] > mapS[i]) {
                return false;
            }
        }

        return true;
    }
}