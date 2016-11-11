import java.util.ArrayList;

/**
 * Created by achaurasia on 11/11/16.
 */
public class MaximumRectangleSumLessThanK {
    public static void main(String[] args) {
        MaximumRectangleSumLessThanK maximumRectangleSumLessThanK = new MaximumRectangleSumLessThanK();
        int matrix[][] = {{10,2,8},{1,7,5},{8,5,2}};
        int matrix1[][] = {{10,10,10},{10,10,10},{1,1,10}};
        int area = maximumRectangleSumLessThanK.getMaxArea(matrix1, 9);
        System.out.println("area = " + area);
    }

    public int getMaxArea(int matrix[][], int k) {
        int m = matrix.length;
        int n = matrix.length;
        int DPHelper[] = new int[m];
        int maxArea = 0;
        for (int L = 0; L < n; L++) {
            for (int R = L; R < n; R++) {
                for (int i = 0; i < m; i++) {
                    DPHelper[i] += matrix[i][R];
                }
                int[] topBottom = ContinousSubArrayLessThanK(DPHelper, k);
                maxArea = maxArea < (topBottom[1] - topBottom[0] + 1)*(R - L + 1) ?
                        (topBottom[1] - topBottom[0] + 1)*(R - L + 1) : maxArea;
            }
            for (int i = 0; i < m; i++) {
                DPHelper[i] = 0;
            }
        }
        return maxArea;
    }

    public int[] ContinousSubArrayLessThanK(int a[], int k) {
        int maxStart = 0;
        int maxEnd = -1;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            while(start < i && sum > k) {
                sum -= a[start++];
            }
            sum += a[i];
            if(sum <= k && i - start > maxEnd - maxStart) {
                maxEnd = i;
                maxStart = start;
            }
        }
        int res[] = {maxStart, maxEnd};
        return res;
    }
}
