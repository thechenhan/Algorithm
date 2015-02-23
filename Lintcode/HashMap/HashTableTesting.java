import java.util.*;

public class HashTableTesting{
    
    public static void main(String[] args){
        HashMap<Integer, String> countMap = new HashMap<Integer, String>();
        int a = 1;
        countMap.put(a, "1");
        for (Map.Entry<Integer, String> entry : countMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + " Values = " + entry.getValue());
        }
        
    }
}