package module4.dsa1.arrays.day17_ArraysLabSession;

public class PrintBoundaryElements {
    public static void main(String[] args) {
        int N = 6;
        int num = 1;
        int[][] matrix = new int[N][N];
        for(int i=0;i< N;i++) {
            for(int j=0; j<N; j++) {
                matrix[i][j] = num++;
            }
        }
        for(int i=0;i< N;i++) {
            for(int j=0; j<N; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


        printMatrixBoundaryElements(matrix);
    }

    /**
     * TODO: enhance this method to print elements in box shape
     * @param matrix
     */
    private static void printMatrixBoundaryElements(int[][] matrix) {
        int N = matrix.length;

        int i=0, j=0;
        while(N>1) {

            for (int k = 0; k < (N - 1); k++) {
                System.out.print(matrix[i][j++] + "-");
            }
            System.out.println();

            for (int k = 0; k < (N - 1); k++) {
                System.out.print(matrix[i++][j] + "->>");
            }
            for (int k = 0; k < (N - 1); k++) {
                System.out.print(matrix[i][j--] + "->>>");
            }
            for (int k = 0; k < (N - 1); k++) {
                System.out.print(matrix[i--][j] + "->>>>");
            }
            i += 1;
            j += 1;
            N -=2;
            //System.out.println(i + "-"+j+"-"+N);
            System.out.println();
        }
        if(N==1){
            System.out.println(matrix[i][j]);
        }
    }
}
