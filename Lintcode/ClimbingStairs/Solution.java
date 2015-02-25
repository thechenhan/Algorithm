public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int f[] = new int[1000];
        f[0] = 1;
        f[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f [i - 2];
        }
       
        return f[n];
    }
}
