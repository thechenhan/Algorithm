//DP
import java.util.ArrayList;

public class Solution {

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        
        //status: if we stop at position[i][j], F[i][j] will be the minimum sum
        int[][] f = new int[1000][1000];
        
        //initilize: the start point, f[0][i], f[i][i]
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i <= (triangle.size() - 1); i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        
        //sovle
        for (int i = 1; i <= (triangle.size() - 1); i++) {
            for (int j = 1; j <= i - 1; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
        }
    
        //get ans
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= (triangle.size() - 1); i++) {
            if (f[triangle.size() - 1][i] < ans) {
                ans = f[triangle.size() - 1][i];
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>(3);
        ArrayList<Integer> level = new ArrayList<Integer>();
        level.add(-1);
        triangle.add(level);
        level = new ArrayList<Integer>();
        level.add(2);
        level.add(3);
        triangle.add(level);
        level = new ArrayList<Integer>();
        level.add(1);
        level.add(-1);
        level.add(-3);
        triangle.add(level);
        System.out.println(minimumTotal(triangle));
    }
}