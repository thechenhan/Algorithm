import java.util.*;

public class Solution {
    //there is an optimization, since the word lenght is limited. If the length of the substring 
    //exceeds the maximum length, the search will stop
    
    //get the maximum word length in the dict
    public static int getMaxLength(Set<String> dict){
        int ans = Integer.MIN_VALUE;
        for (String word : dict) {
            if (word.length() > ans){
                ans = word.length();
            }        
        }
        return ans;  
    }
    
    //dp
    public boolean wordSegmentation(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }
        
        int maxWordLength = getMaxLength(dict);
        boolean[] F = new boolean[s.length() + 1];
        F[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            F[i] = false;
            for(int j = Math.max(0, i - maxWordLength); j < i; j++) {
                F[i] = F[i] || (F[j] && dict.contains(s.substring(j, i)));
            }
        }
        
        return F[s.length()];
    }

}