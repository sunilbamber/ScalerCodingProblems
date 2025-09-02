package module4.dsa1.recursion.day21_RecursionLab;

import java.util.*;

public class TowerOfHanoi {

    public static List<int[]> moves;

    public static int[][] towerOfHanoi(int A) {
        moves = new ArrayList<>();
        solve(A, 1, 3, 2);  // From tower 1 to tower 3 using tower 2
        return moves.toArray(new int[0][]);
    }

    private static void solve(int n, int from, int to, int aux) {
        if (n == 0) return;

        // Step 1: Move n-1 disks from 'from' to 'aux'
        solve(n - 1, from, aux, to);

        // Step 2: Move nth disk from 'from' to 'to'
        moves.add(new int[]{n, from, to});

        // Step 3: Move n-1 disks from 'aux' to 'to'
        solve(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        int A = 3;
        int[][] result = towerOfHanoi(A);

        for (int[] move : result) {
            System.out.println(Arrays.toString(move));
        }
    }
}