package module4.dsa1.bit_manipulation.day18_BitManipulation;

public class Count1sBit {
    public static int countOneBits(int n) {
        /**
         * Method: Brian Kernighan’s Algorithm
         * Explanation
         *
         * Each time you perform n = n & (n - 1), it removes the lowest set bit from n.
         * So the number of operations equals the number of 1s.
         * Time Complexity
         * 	•	Time: O(k), where k is the number of set bits (better than checking all 32 bits)
         * 	•	Space: O(1)
         */
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // Drops the lowest set bit
            count++;
        }
        return count;
    }
    public static int countOneBits2(int n) {
        /**
         * Key Points:
         * 	•	n & 1: Checks if the least significant bit (LSB) is 1.
         * 	•	n >>> 1: Unsigned right shift (to fill with 0 on the left),
         * 	    important for handling negative numbers in Java.
         * 	•	If you use n >> 1 (arithmetic shift), the sign bit (1 for negatives) will keep replicating,
         * 	    causing an infinite loop.
         * 	Time Complexity
         * 	•	Time: O(32) → Constant time (since Java int is 32 bits)
         * 	•	Space: O(1)
         */
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;  // Use unsigned right shift to handle negatives correctly
        }

        return count;
    }

    public static void main(String[] args) {
        int number = 29;
        String binary = Integer.toBinaryString(number);
        System.out.println("Binary of " + number + " = " + binary);
        System.out.println("Number of 1 bits: " + countOneBits(number));

        number = 54;
        binary = Integer.toBinaryString(number);
        System.out.println("Binary of " + number + " = " + binary);
        System.out.println("Number of 1 bits: " + countOneBits(number));
    }
}
