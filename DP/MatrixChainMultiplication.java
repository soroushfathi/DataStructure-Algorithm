package DP;

public class MatrixChainMultiplication {
    public static int milMul(int n, int[] d, int[][] p){
        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++)
            m[i][i] = 0;
        for (int L = 1; L < n; L++) {
            for (int i = 0; i < n - L; i++) {
                int j = i + L;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    // min val of multiply matrices i...j
                    int count = m[i][k] + m[k+1][j] + d[i]*d[k+1]*d[j+1];
                    if (count <= min){
                        min = count;
                        p[i][j] = k;
                        m[i][j] = min;
                    }
                }
            }
        }
        return m[0][n-1];
    }

    public static void printOrder(int i, int j, int[][] p) {

    }

    public static void main(String[] args) {
        int res = milMul(4, new int[]{20, 2, 30, 10, 5}, new int[5][5]);
        System.out.println(res);
    }
}
