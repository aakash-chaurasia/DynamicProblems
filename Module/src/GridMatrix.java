import java.util.Scanner;

/**
 * Created by Aakash on 11/12/2016.
 */
public class GridMatrix {
    private int matrix[][];
    private int m;
    private int n;

    public GridMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of rows");
        this.m = sc.nextInt();
        System.out.println("Enter no of Cols");
        this.n = sc.nextInt();
        this.matrix = new int[m][n];
        sc.nextLine();
    }

    public int[][] GridInput() {
        System.out.println("Enter values space separate for example 1 2 3.");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            String[] inputLine = sc.nextLine().split(" ");
            for (int j = 0; j < inputLine.length && j < n; j++) {
                matrix[i][j] = Integer.parseInt(inputLine[j]);
            }
        }
        return matrix;
    }
}
