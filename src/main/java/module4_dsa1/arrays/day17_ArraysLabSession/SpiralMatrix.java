package module4_dsa1.arrays.day17_ArraysLabSession;

public class SpiralMatrix {
    /**
     * Problem Description
     * Given an integer A, generate a square matrix filled with elements from 1 to A2 in
     * spiral order and return the generated square matrix.
     *
     * Problem Constraints
     * 1 <= A <= 1000
     */
    public static int[][] generateMatrix(int A) {
        /**
         * Spiral Filling Order:
         * 	1.	Left → Right (Top row)
         * 	2.	Top → Bottom (Right column)
         * 	3.	Right → Left (Bottom row)
         * 	4.	Bottom → Top (Left column)
         * Repeat until all cells are filled.
         */

        int result[][] = new int[A][A];
        int top = 0, bottom = A-1;
        int left=0, right=A-1;
        int counter = 1;
        while(top<=bottom && left<=right) {
            for(int i=left;i<=right;i++) {
                result[top][i] = counter++;
            }
            top++;
            printMatrix(result);
            System.out.println(top + "-" + bottom + "-" + left + "-" + right);
            for(int i=top;i<=bottom;i++) {
                result[i][right] = counter++;
            }
            right--;
            printMatrix(result);
            System.out.println(top + "-" + bottom + "-" + left + "-" + right);
            if(top<=bottom) {
                for(int i=right; i>=left; i--) {
                    result[bottom][i] = counter++;
                }
                bottom--;
            }
            printMatrix(result);
            System.out.println(top + "-" + bottom + "-" + left + "-" + right);
            if(left <=right) {
                for(int i=bottom; i>=top; i--) {
                    result[i][left]=counter++;
                }
                left++;
            }
            printMatrix(result);
            System.out.println(top + "-" + bottom + "-" + left + "-" + right);
        }
        return result;
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int A = 4;
        int[][] spiral = generateMatrix(A);
        printMatrix(spiral);
    }
}
