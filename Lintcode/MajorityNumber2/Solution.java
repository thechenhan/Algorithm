import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public static int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int candidate1;
        int candidate2;
        
        if (nums.get(0) == nums.get(1)) {
            candidate1 = nums.get(0);
            candidate2 = nums.get(2);
        } else {
            candidate1 = nums.get(0);
            candidate2 = nums.get(1); 
        }
       
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (candidate1 == nums.get(i)) {
                count1++;
            } else if (candidate2 == nums.get(i)) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums.get(i);
            } else if (count2 == 0) {
                candidate2 = nums.get(i);
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2++;
            }
        }
        
        if (count1 > count2) {
            return candidate1;
        } else {
            return candidate2;
        }
       
        
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(7);
        a.add(1);
        a.add(7);
        a.add(7);
        a.add(61);
        a.add(61);
        a.add(61);
        a.add(10);
        a.add(10);
        a.add(10);
        a.add(61);
        int ans = majorityNumber(a);
        
        
    }
}

