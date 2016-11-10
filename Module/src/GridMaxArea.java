/**
 * Created by Aakash on 11/9/2016.
 */
public class GridMaxArea {
    int count = 0;
    int k = 9;
    int grid[][];
    public static void main(String[] args) {
        GridMaxArea gridMaxArea = new GridMaxArea();
        int _grid[][] = {{10, 10, 10}, {10, 10, 10}, {10, 10, 10}};
        gridMaxArea.grid = _grid;
        int sum = 0;
        gridMaxArea.interpolateArea(0, 0, 0, 0, 0);

        System.out.println("gridMaxArea.count = " + gridMaxArea.count);
    }

    private void interpolateArea(int i, int j, int i1, int j1, int s) {
        System.out.println("GridMaxArea.interpolateArea");
        System.out.println("i = [" + i + "], j = [" + j + "], i1 = [" + i1 + "], j1 = [" + j1 + "], s = [" + s + "], count = [" + count + "]");
        if(i1 < grid.length && j1 < grid[0].length) {
            int x = grid[i1][j1];
            int v = 0;
            int h = 0;
            for (int l = i; l < i1; l++) {
                v += grid[l][j1];
            }
            for (int l = j; l < j1; l++) {
                h += grid[i1][l];
            }
            if (s + x + v + h <= k) {
                s =  s + x + v + h;
                count = count < (i1 - i + 1) * (j1 - j + 1) ? (i1 - i + 1) * (j1 - j + 1) : count;
                interpolateArea(i, j, i1 + 1, j1 + 1, s);
                interpolateColumn(i, j, i1, j1 + 1, s);
                interpolateRow(i, j, i1 + 1, j1, s);
            }
            interpolateArea(i1 + 1, j1, i1 + 1, j1, 0);
            interpolateArea(i1, j1 + 1, i1, j1 + 1, 0);
        }
    }

    private void interpolateColumn(int i, int j, int i1, int j1, int s) {
        System.out.println("GridMaxArea.interpolateColumn");
        System.out.println("i = [" + i + "], j = [" + j + "], i1 = [" + i1 + "], j1 = [" + j1 + "], s = [" + s + "], count = [" + count + "]");
        if(i1 < grid.length && j1 < grid[0].length) {
            int v = 0;
            for (int l = i; l <= i1; l++) {
                v += grid[l][j1];
            }
            if( s + v <= k) {
                s += v;
                count = count < (i1 - i + 1) * (j1 - j + 1) ? (i1 - i + 1) * (j1 - j + 1) : count;
                interpolateColumn(i, j, i1, j1 + 1, s);
            }
            interpolateArea(i1, j1, i1, j1, 0);
        }
    }

    private void interpolateRow(int i, int j, int i1, int j1, int s) {
        System.out.println("GridMaxArea.interpolateRow");
        System.out.println("i = [" + i + "], j = [" + j + "], i1 = [" + i1 + "], j1 = [" + j1 + "], s = [" + s + "], count = [" + count + "]");
        if(i1 < grid.length && j1 < grid[0].length) {
            int h = 0;
            for (int l = j; l <= j1; l++) {
                h += grid[i1][l];
            }
            if( s + h <= k) {
                s += h;
                count = count < (i1 - i + 1) * (j1 - j + 1) ? (i1 - i + 1) * (j1 - j + 1) : count;
                interpolateColumn(i, j, i1 + 1, j1, s);
            }
            interpolateArea(i1, j1, i1, j1, 0);
        }
    }
}
