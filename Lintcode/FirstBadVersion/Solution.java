public class Solution {
    
    public int findFirstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }
        
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (VersionControl.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (VersionControl.isBadVersion(start)){
            return start;
        } else {
            return end;
        }
        
    }  
}