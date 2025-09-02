package module4.dsa1.recursion.day20_Recursion;

public class DecThenInc {
    static void decThenInc(int A) {
        if(A==0) return;
        else {
            System.out.print(A+" ");
            decThenInc(A-1);
            System.out.print(A+" ");
        }
    }

    public static void main(String[] args) {
        decThenInc(4);
    }
}
