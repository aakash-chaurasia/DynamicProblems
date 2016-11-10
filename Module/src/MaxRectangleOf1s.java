import java.util.Stack;

/**
 * Created by Aakash on 11/10/2016.
 */
public class MaxRectangleOf1s {
    public static void main(String[] args) {
        MaxRectangleOf1s maximalRectangle = new MaxRectangleOf1s();
        char matrix[][] = {{'1','0','1'},{'1','0','1'}, {'1','1','1'}, {'1','0','0'}};
        char matrix1[][] = {{'0','1'}, {'1','0'}};
        int res = maximalRectangle.maximalRectangle(matrix1);
        res = maximalRectangle.MaximalRectangleOptimized(matrix1);
        System.out.println("res = " + res);
    }
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        if(matrix.length > 0) {
            int cols[] = new int[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < cols.length; j++) {
                    if (matrix[i][j] == '0') {
                        cols[j] = 0;
                    } else {
                        cols[j] += 1;
                    }
                }
                int temp = largestRectangleHistogram(cols);
                result = result < temp ? temp : result;
            }
        }
        return result;
    }
    public int largestRectangleHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        for (i = 0; i < heights.length; i++) {
            int i1 = heights[i];
            if(stack.empty() || heights[stack.peek()] <= i1) {
                stack.push(i);
            } else {
                int temp = stack.pop();
                int new_area = 0;
                if(stack.empty()) {
                    new_area = heights[temp]*i;
                } else {
                    new_area = heights[temp] * (i - stack.peek() - 1);
                }
                max = max < new_area ? new_area : max;
                i--;
            }
        }
        while(!stack.empty()) {
            int temp = stack.pop();
            int new_area = 0;
            if(stack.empty()) {
                new_area = heights[temp] * i;
            } else {
                new_area = heights[temp] * (i - stack.peek() - 1);
            }
            max = max < new_area ? new_area : max;
        }
        return max;
    }

    public int MaximalRectangleOptimized(char[][] matrix) {
        int result = 0;
        if(matrix.length > 0) {
            int m = matrix.length;
            int n = matrix[0].length;
            int left[] = new int[n];
            int right[] = new int[n];
            int height[] = new int[n];
            for (int i = 0; i < n; i++) {
                right[i] = n;
            }
            for (int i = 0; i < m; i++) {
                int curLeft = 0;
                int curRight = n;
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] == '1') {
                        height[j] += 1;
                    } else {
                        height[j] = 0;
                    }
                }

                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] == '1') {
                        left[j] = Math.max(left[j], curLeft);
                    } else {
                        left[j] = 0;
                        curLeft = j + 1;
                    }
                }

                for (int j = n - 1; j > -1; j--) {
                    if(matrix[i][j] == '1') {
                        right[j] = Math.min(right[j], curRight);
                    } else {
                        right[j] = n;
                        curRight = j;
                    }
                }

                for (int j = 0; j < n; j++) {
                    result = Math.max(result, (right[j] - left[j])*height[j]);
                }
            }
        }
        return result;
    }
}