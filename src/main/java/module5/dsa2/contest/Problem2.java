package module5.dsa2.contest;

import java.util.Arrays;

/**
 * Problem: Least capacity to ship
 * Given array of N packages to be shipped within B days
 * The ith package has A[i] kg weight to be shipped. Each day, the ship loads the packages to ship them to another port
 *
 * Return the least weight capacity of ship that will result in all packages to be shipped within B days.
 */
public class Problem2 {

    public static void main(String[] args) {
        int[] input = {1,2,3,1,1};//4,5,6,7,8,9,10};
        int B = 4;
        int result = solve(input, B);
        System.out.println("Given weights "+ Arrays.toString(input) + " to be shipped in "+B+ " days");
        System.out.println("Least weight capacity of ship is : "+result);
    }
    static int solve(int[] A, int B) {
        int sum = 0;
        int max = 0;
        for(int i=0;i<A.length;i++) {
            sum += A[i];
            max = Math.max(max, A[i]);
        }

        int low = max;
        int high = sum;
        int res = 0;

        while(low <= high) {
            int mid = low + (high - low)/2;
            System.out.println("Running --> low: "+low + " mid: "+mid+ " high: "+high);
            if(check(A, B, mid)) {
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }

        }
        return res;
    }

    private static boolean check(int[] A, int B, int mid) {
        int count = 1;
        int sum = 0;
        for(int i=0;i<A.length;i++) {
            sum += A[i];
            if(sum>mid) {
                count++;
                sum=0;
            }
        }
        return count<=B;
    }
}
