public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        if (A == null || A.length == 0){
            return A;
        }
        
        //the offset can larger than the s.length();
        offset = offset % A.length;
        String str = String.valueOf(A);
        str = (str + str).substring(str.length() - offset, 2 * str.length() - offset);
        return str.toCharArray();
    }
}
    
