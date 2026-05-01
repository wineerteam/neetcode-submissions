class Solution {

    // Encode
    public String encode(List<String> strs) {

        StringBuilder ans = new StringBuilder();

        for (String s : strs) {

            ans.append(s.length())
               .append("#")
               .append(s);
        }

        return ans.toString();
    }


    // Decode
    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            // # find karo
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            // length nikalo
            int len = Integer.parseInt(str.substring(i, j));

            // word nikalo
            String word = str.substring(j + 1, j + 1 + len);

            ans.add(word);

            // next position
            i = j + 1 + len;
        }

        return ans;
    }
}