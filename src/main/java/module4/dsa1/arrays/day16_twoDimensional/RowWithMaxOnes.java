package module4.dsa1.arrays.day16_twoDimensional;

public class RowWithMaxOnes {

    public static int rowWithMaxOnes(int[][] A) {
        int N = A.length;
        int i = 0, j = N - 1;
        int maxRow = -1;

        while (i < N && j >= 0) {
            if (A[i][j] == 1) {
                maxRow = i;  // Found more 1s in current row
                j--;         // Move left
            } else {
                i++;         // Move down
            }
        }

        return maxRow;
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        };

        System.out.println("Row with max 1s: " + rowWithMaxOnes(A)); // Output: 3
    }
}
