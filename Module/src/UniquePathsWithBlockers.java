/**
 * Created by Aakash on 11/6/2016.
 */
public class UniquePathsWithBlockers {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = 1;
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] != 0) {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] != 0) {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if(obstacleGrid[i][j] != 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[obstacleGrid.length - 1].length - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithBlockers uniquePaths2 = new UniquePathsWithBlockers();
        int mat[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int mat1[][] = {{1, 0}};
        int result = uniquePaths2.uniquePathsWithObstacles(mat1);
        System.out.println("result = " + result);
    }
}
