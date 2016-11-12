/**
 * Created by Aakash on 11/12/2016.
 */

 /*
 Inputs
14 13 10 9
13 12 11 10
12 9 10 9
7 8 3 2
6 5 4 10

12 9 10
7 8 3
6 5 4

13 14 15 13
12 11 16 17
23 10 15 18
24 21 20 19
23 22 21 24

13 14 15 13
12 11 16 17
23 10 9 18
24 21 20 19
23 22 21 24

13 14 15 13
12 11 16 17
23 10 9 20
24 21 20 19
23 22 21 24

13 14 18 13
12 11 18 17
25 10 9 20
24 21 20 19
23 22 21 24

 */
public class LongestSequenceInMatrix {
    int RESULT = 0;
    int DPHelper[][];

    public static void main(String[] args) {
        LongestSequenceInMatrix sequenceInMatrix = new LongestSequenceInMatrix();
        GridMatrix gridMatrix = new GridMatrix();
        int[][] matrix = gridMatrix.GridInput();
        int res = sequenceInMatrix.getMaxSequence(matrix);
        System.out.println("res = " + res);
    }

    private int getMaxSequence(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        DPHelper = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(DPHelper[i][j] == 0) {
                    int curr = matrix[i][j];
                    int top = i > 0 ? matrix[i - 1][j] : -1;
                    int left = j > 0 ? matrix[i][j - 1] : -1;
                    int right = j < n - 1 ? matrix[i][j + 1] : -1;
                    int bottom = i < m - 1 ? matrix[i + 1][j] : -1;
                    top = curr - top == 1 ? (DPHelper[i - 1][j] == 0 ? 2 : DPHelper[i - 1][j] + 1): -1;
                    left = curr - left == 1 ? (DPHelper[i][j - 1] == 0 ? 2 : DPHelper[i][j - 1] + 1): -1;
                    right = curr - right == 1 ? (DPHelper[i][j + 1] == 0 ? 2 : DPHelper[i][j + 1] + 1): -1;
                    bottom = curr - bottom == 1 ? (DPHelper[i + 1][j] == 0 ? 2 : DPHelper[i + 1][j] + 1): -1;
                    int maxVal = maxAllDirection(DPHelper[i][j], top, left, bottom, right);
                    if(maxVal != DPHelper[i][j]) {
                        DPHelper[i][j] = maxVal;
                        propagateUpdate(matrix, i, j);
                    } else if (maxVal == 0) {
                        DPHelper[i][j] = 1;
                    }
                }
            }
        }
        return RESULT;
    }

    private void propagateUpdate(int[][] matrix, int i, int j) {
        int currDp = DPHelper[i][j];
        int curr = matrix[i][j];
        int top = i > 0 ? matrix[i - 1][j] : -1;
        int left = j > 0 ? matrix[i][j - 1] : -1;
        int right = j < matrix[0].length - 1 ? matrix[i][j + 1] : -1;
        int bottom = i < matrix.length - 1 ? matrix[i + 1][j] : -1;
        if(top - curr == 1) {
            RESULT = Math.max(RESULT, currDp + 1);
            if(DPHelper[i - 1][j] < currDp + 1) {
                DPHelper[i - 1][j] = currDp + 1;
                propagateUpdate(matrix, i - 1, j);
            }
        }
        if(left - curr == 1) {
            RESULT = Math.max(RESULT, currDp + 1);
            if(DPHelper[i][j - 1] < currDp + 1) {
                DPHelper[i][j - 1] = currDp + 1;
                propagateUpdate(matrix, i, j - 1);
            }
        }
        if(bottom - curr == 1) {
            RESULT = Math.max(RESULT, currDp + 1);
            if(DPHelper[i + 1][j] < currDp + 1) {
                DPHelper[i + 1][j] = currDp + 1;
                propagateUpdate(matrix, i + 1, j);
            }
        }
        if(right - curr == 1) {
            RESULT = Math.max(RESULT, currDp + 1);
            if(DPHelper[i][j + 1] < currDp + 1) {
                DPHelper[i][j + 1] = currDp + 1;
                propagateUpdate(matrix, i, j + 1);
            }
        }
    }

    private int maxAllDirection(int curr, int top, int left, int bottom, int right) {
        int max = Math.max(Math.max(Math.max(Math.max(bottom, right), left), top), curr);
        RESULT = Math.max(RESULT, max);
        return max;
    }
}
