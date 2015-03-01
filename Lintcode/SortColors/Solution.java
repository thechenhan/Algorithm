class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int n = nums.length - 1;
        int i = 0;
        int j = n;
        while (i < j) {
            while (i < j && nums[i] == 0) {
                i++;
            }
            while (i < j && nums[j] != 0) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        j = n;
        
        while (i < j) {
            while (i < j && nums[i] == 1) {
                i++;
            }
            while (i < j && nums[j] == 2) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
 
    }
}
