import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> heightIndex = new Stack<Integer>();
        heightIndex.push(0);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= height.length; i++) {
            int curr = -1;
            if (i != height.length) {
                curr = height[i];
            }
            
            while (!heightIndex.empty() && curr <= height[heightIndex.peek()]) {
                int h = height[heightIndex.pop()];
                int w = (heightIndex.empty())? i : i - heightIndex.peek() - 1;
                max = Math.max(max, h * w);                
            }
            
            heightIndex.push(i);
        }
        
        return max;
    }
}