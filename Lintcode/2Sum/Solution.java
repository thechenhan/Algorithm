import java.util.*;

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(numbers[i], i);
        }
        
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - numbers[i])) {
                ans[0] = i + 1;
                ans[1] = map.get(target - numbers[i]) + 1;
                return ans;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = twoSum(a, 9);
    }
}
