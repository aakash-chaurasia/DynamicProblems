/**
 * Created by Aakash on 11/6/2016.
 */
public class MarioAndPrincess {
    public int calculateMinimumHP1(int[][] dungeon) {
        int m  = dungeon.length;
        int n = dungeon[0].length;
        int str[][] = new int[m][n];
        str[0][0] = dungeon[0][0] >= 0 ? 0 : dungeon[0][0];
        for (int i = 1; i < m; i++) {
            dungeon[i][0] += dungeon[i - 1][0];
            str[i][0] = Math.min(dungeon[i][0], str[i - 1][0]);
        }
        for (int i = 1; i < n; i++) {
            dungeon[0][i] += dungeon[0][i - 1];
            str[0][i] = Math.min(dungeon[0][i], str[0][i - 1]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int temp1 = dungeon[i][j] + dungeon[i - 1][j];
                int temp2 = dungeon[i][j] + dungeon[i][j - 1];
                if(temp1 + str[i - 1][j] > str[i][j - 1] + temp2 ) {
                    dungeon[i][j] = temp1;
                    str[i][j] = Math.min(dungeon[i][j], str[i -1][j]);
                } else {
                    dungeon[i][j] = temp2;
                    str[i][j] = Math.min(dungeon[i][j], str[i][j - 1]);
                }
                /*if(dungeon[i - 1][j] > dungeon[i][j - 1]) {
                    dungeon[i][j] += dungeon[i - 1][j];
                    str[i][j] = Math.min(dungeon[i][j], str[i -1][j]);
                } else {
                    dungeon[i][j] += dungeon[i][j - 1];
                    str[i][j] = Math.min(dungeon[i][j], str[i][j - 1]);
                }*/
            }
        }
        return str[m - 1][n - 1]*(-1) + 1;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m  = dungeon.length;
        int n = dungeon[0].length;
        dungeon[m - 1][n - 1] = Math.min(0, dungeon[m - 1][n - 1]);
        for (int i = m - 2; i >= 0 ; i--) {
            dungeon[i][n - 1] = Math.min(0, dungeon[i][n - 1] + dungeon[i + 1][n - 1]);
        }

        for (int i = n - 2; i >= 0 ; i--) {
            dungeon[m - 1][i] = Math.min(0, dungeon[m - 1][i] + dungeon[m - 1][i + 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0 ; j--) {
                dungeon[i][j] =  Math.min(0, Math.max(dungeon[i + 1][j], dungeon[i][j + 1]) + dungeon[i][j]);
            }
        }

        return -1*dungeon[0][0] + 1;
    }

    public static void main(String[] args) {
        MarioAndPrincess dungeon = new MarioAndPrincess();
        int mat[][] = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
        int mat3[][] = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int mat1[][] = {{1, 0}};
        int mat2[][] = {{0}};
        int res = dungeon.calculateMinimumHP(mat3);
        System.out.println("res = " + res);
    }
}
