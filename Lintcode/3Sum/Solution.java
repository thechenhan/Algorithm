import java.util.*;

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue; //remove duplicate
            }
            int target = 0 - numbers[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == target) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    ans.add(list);
                    while (left < right && numbers[left + 1] == numbers[left]) {
                        left++; //remove duplicate
                    }
                    while (left < right && numbers[right - 1] == numbers[right]) {
                        right--;
                    }
                    
                } else if (numbers[left] + numbers[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return ans;
    }
}
