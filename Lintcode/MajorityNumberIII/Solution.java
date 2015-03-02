import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i))) {
                map.put(nums.get(i), map.get(nums.get(i)) + 1);
            } else {
                if (map.size() < k) {
                    map.put(nums.get(i), 1);
                } else {
                    //this array is used for recording which number should be deleted
                    ArrayList<Integer> delete = new ArrayList<Integer>();
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        map.put(entry.getKey(), entry.getValue() - 1);
                        if (entry.getValue() == 0) {
                            delete.add(entry.getKey());
                        }
                    }
                    //remove the empty map, because we cannot remove things in-place;
                    for (int j = 0; j < delete.size(); j++) {
                        map.remove(delete.get(j));
                    }
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.put(entry.getKey(), 0);
        }
        
        int max = 0;
        int ans = 0;        
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i))) {
                map.put(nums.get(i), map.get(nums.get(i)) + 1);
                if (map.get(nums.get(i)) > max) {
                    max = map.get(nums.get(i));
                    ans = nums.get(i);
                }
            }
        }
        
        return ans;
    }
}

