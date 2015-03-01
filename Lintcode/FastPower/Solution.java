class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public long fastPower(int a, int b, int n) {
        // write your code here
        long ans = 1;
        long pow = a % b;
        
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * pow % b;
            }
            pow = pow * pow % b;
            n = n / 2;
        }
        
        return  ans % b;
    }
};
