public class Solution {

    //without time optimization
  
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    
    //dp
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
    
        int[] cut = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            cut[i] = i - 1;
        }
        
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome(s, j, i - 1)) {
                    cut[i] = Math.min(cut[j] + 1, cut[i]);
                }
            }
        }
        
        return cut[s.length()];               
        
    }

}