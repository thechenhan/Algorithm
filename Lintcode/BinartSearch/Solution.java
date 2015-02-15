public class Solution{

    public static int binarySearch(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target){
                start = mid;
            } else if (nums[mid] > target){
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        
        if (nums[end] == target) {
            return end;
        }
        
        return -1;        
    }
    
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,10};
        System.out.println(binarySearch(nums, 3));
    }
    
}
