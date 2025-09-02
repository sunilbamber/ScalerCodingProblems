package module5.dsa2.contest;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array A of daily temperatures of N days where A[i] represents temperature of ith day,
 *
 * Task is to find the minimum n of days you have to wait after each day until you can see a warmer day
 * If no future day is possible, put 0
 *
 * Example: [75,71,69,72,76,73]
 * Output: [4,2,1,1,0,0]
 */
public class Problem3 {

    public static void main(String[] args) {
        int[] A = {75,71,69,72,76,73};
        System.out.println("Temperatures for all days: "+Arrays.toString(A));
        System.out.println("Result: "+Arrays.toString(warmerDays(A, A.length)));
    }
    static int[] warmerDays(int[] A, int N) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[N];
        for(int i=N-1;i>=0;i--) {
            while(!stack.isEmpty() && A[stack.peek()] <= A[i])
                stack.pop();
            if(stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
