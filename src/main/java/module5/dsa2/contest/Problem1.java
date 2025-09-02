package module5.dsa2.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem1 {

    public static void main(String[] args) {
        int[][] input = {
            {1,5},
            {1,4},
            {1,6},
            {1,5},
            {1,4},
                {0,0},
            {1,5},
            {1,6},
            {0,4},
            {0,5}
        };
        int[] result = solve(input, input.length);
        System.out.println(Arrays.toString(result));
    }

    static int[] solve(int[][] A, int N) {
        int[] res = new int[N];
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Stack<Integer>> freqStack = new HashMap<>();
        int maxFreq = 0;
        for(int i=0;i<N;i++) {
            if (A[i][0] == 1) { // push operation
                System.out.println("----PUSH----");
                int x = A[i][1];
                freqMap.put(x, freqMap.getOrDefault(x,0)+1);
                maxFreq = Math.max(maxFreq, freqMap.get(x));
                freqStack.putIfAbsent(freqMap.get(x), new Stack<>());
                freqStack.get(freqMap.get(x)).push(x);
                res[i] = -1;
            } else { // pop operation
                System.out.println("----POP----");
                int x = freqStack.get(maxFreq).pop();
                res[i] = x;
                freqMap.put(x, freqMap.get(x)-1);
                if(freqStack.get(maxFreq).isEmpty()) {
                    maxFreq--;
                }
            }
            System.out.println("MaxFreq: "+maxFreq);
            System.out.println(freqMap);
            System.out.println(freqStack);
            System.out.println("Result: "+Arrays.toString(res));
        }
        return res;
    }
}
