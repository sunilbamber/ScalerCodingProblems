package module4.dsa1.arrays.day16_twoDimensional;

public class MinSwaps {

    public static int minSwaps(int[] A, int B) {
        int n = A.length;
        int count = 0;

        // Step 1: Count how many elements are ≤ B
        for (int num : A) {
            if (num <= B) count++;
        }
        System.out.println("Count: "+count);

        // Step 2: Count elements > B in the first window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (A[i] > B) bad++;
        }
        System.out.println("Bad: "+bad);

        int minSwaps = bad;

        // Step 3: Slide the window and track min bad count
        for (int i = count; i < n; i++) {
            if (A[i - count] > B) bad--;  // element going out
            if (A[i] > B) bad++;          // element coming in
            minSwaps = Math.min(minSwaps, bad);
            System.out.println("A[i-count]: "+A[i-count] + " A[i]: "+A[i]+ " Count: "+i + " Bad count: "+bad + " Min swaps: "+minSwaps);
        }

        return minSwaps;
    }

    public static void main(String[] args) {
        int[] A = {31,98,58,86,36,31,3,22,4,17,51,33,56,7,91,17,59,66,54,67,55,41,58,24,100,1,98,68,21,33,27,67,20,66,20,100,36,89,20,15,13,26,11,29,99,36,39,49,74,77,54,66,30,21,14,18,83,72,10,22,53,83,60,9,68,56,9,21,77,44,45,61,97,82,35,16,38,95,55,11,46,77,25,3,44};
        int B = 18;

        System.out.println("Minimum swaps needed: " + minSwaps(A, B)); // Output: 2
    }
}
