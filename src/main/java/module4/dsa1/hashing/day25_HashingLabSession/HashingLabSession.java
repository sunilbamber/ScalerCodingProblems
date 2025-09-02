package module4.dsa1.hashing.day25_HashingLabSession;

import java.util.*;

public class HashingLabSession {

    public int findFirstNonRepeatingNumber(int[] A) {
        /*
        approach
            1. construct frequency hashmap
            2. Iterate the array again and find out the 1st element with freq 1
         */
        int res = -1;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : A) {
            if(freqMap.get(num) == 1) {

            }
        }
        return res;



    }

    public int checkSubarrayWithSumZero(int[] A) {
        /*
        approach
            1. Create prefix sum array
            2. Check if any element occur twice in prefix sum
            3. if exists, there is subArray between them with sum zero
         */
        return  -1;
    }

    public static void main(String[] args) {
        int[] subArraySum={1,-3,1,2,-4,6,2,-4,1,-5,7};
    }
}
