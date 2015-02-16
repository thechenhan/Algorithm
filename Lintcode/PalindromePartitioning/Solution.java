import java.util.List;
import java.util.ArrayList;

public class Solution {
    
     public static boolean isPalindrome(String s) {
         int i = 0, j = s.length() - 1;
         while (i < j) {
             if (s.charAt(i) != s.charAt(j)) {
                 return false;
             }
             i++;
             j--;
         }
         return true;
     }

     public ArrayList<ArrayList<String>> partition(String s) {
         List<List<String>> ans = new ArrayList<List<String>>();
         ArrayList<String> list = new ArrayList<String>();
         
         if (s == null) {
             return ans;
         }
         
         searchAns(list, ans, s);
         return ans;
       
     }
     
     private static void searchAns(ArrayList<String> list, ArrayList<ArrayList<String>> ans, String s){
         if (s == null) {
             ans.add(new ArrayList<String>(list));
             return;
            }
         
         for (int i = 1; i <= s.length(); i++) {
             if (isPalindrome(s.substring(0, i))) {
                 list.add(s.substring(0, i));
                 if (i == s.length()) {
                     searchAns(list, ans, null);
                 } else {
                     searchAns(list, ans, s.substring(i, s.length()));
                 }
                 list.remove(list.size() - 1);
             }
  
         }
         
        
     }


}
