import java.util.*;

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
   
    public void inverseArrayList(ArrayList<Integer> nums, int i, int j) {
        while (i < j) {
            int temp = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,temp);
            i++;
            j--;
        }
    }
    
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i+1)) {
                inverseArrayList(nums, 0, i);
                inverseArrayList(nums, i+1, nums.size() - 1);
                inverseArrayList(nums, 0, nums.size() - 1);
                return;
            } 
        }
    }
}
