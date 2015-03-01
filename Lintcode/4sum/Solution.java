import java.util.*;

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        int n = numbers.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (n < 4) {
            return ans;
        }
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && !map.containsKey(numbers[i] + numbers[j])) {
                    ArrayList<Integer> num = new ArrayList<Integer>(2);
                    num.add(i);
                    num.add(j);
                    map.put(numbers[i] + numbers[j], num);
                } else if (map.containsKey(numbers[i] + numbers[j])) {
                    if (!map.get(numbers[i] + numbers[j]).contains(i) 
                        || !map.get(numbers[i] + numbers[j]).contains(j)) {
                        map.get(numbers[i] + numbers[j]).add(i);
                        map.get(numbers[i] + numbers[j]).add(j);
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && map.containsKey(target - numbers[i] - numbers[j])) {
                    for (int k = 0; k <= map.get(target - numbers[i] - numbers[j]).size() / 2; k = k + 2) {
                        int index3 = map.get(target - numbers[i] - numbers[j]).get(k);
                        int index4 = map.get(target - numbers[i] - numbers[j]).get(k + 1);
                        if (i != index3 && i != index4 && j != index3 && j != index4
                            && index3 != index4) {
                            ArrayList<Integer> list = new ArrayList<Integer>();
                            list.add(numbers[i]);
                            list.add(numbers[j]);
                            list.add(numbers[index3]);
                            list.add(numbers[index4]);
                            Collections.sort(list);
                            if (!ans.contains(list)) {
                                ans.add(list);
                            }
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}