import java.util.*;

public class Solution {
    private Stack<Integer> sRegular;
    private Stack<Integer> sMin;
    

    public Solution() {
        sRegular = new Stack<Integer>();
        sMin = new Stack<Integer>();
    }
    
    
    public  void push(int num) {
        sRegular.push(num);
        if (sMin.empty()) {
            sMin.push(num);
        } else {
            if (num <= sMin.peek()) {
                sMin.push(num);
            }
        }
    }
    
    public  int pop() {
       //System.out.println((int)sMin.peek() == (int)sRegular.peek());
       //if compare two objects, please use .equals
       if ((int)sMin.peek() == (int)sRegular.peek()) {
           sMin.pop();
           return sRegular.pop();
       } else {
           return sRegular.pop();
       }
    }
    
    public  int min() {
        if (!sMin.empty()) {
            return sMin.peek();
        } else {
            return 0;
        }
        
    }

    public static void main(String[] srgs) {
        Solution s = new Solution();
        s.push(152);
        s.pop();
        s.push(163);
        s.min();
        
    }
}
