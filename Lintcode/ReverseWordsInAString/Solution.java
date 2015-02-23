public class Solution {

 public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String ans = new String();
     
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                int j = i;
                while (j < s.length() - 1 && s.charAt(j + 1) != ' ') {
                    j++;
                }
                ans = s.substring(i, j + 1) + " " + ans;
                i = j + 1;
            }
        }
        
        if (ans.length() == 0) {
            return ans;
        }
        
        return ans.substring(0, ans.length() - 1);
    }

}