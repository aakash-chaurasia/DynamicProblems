import java.util.Stack;

/**
 * Created by Aakash on 11/10/2016.
 * Max Rectangular area in a array.
 */
public class MaxHistogramArea {
    public static void main(String[] args) {
        MaxHistogramArea maxHistogramArea = new MaxHistogramArea();
        int a[] = {3, 2, 4, 5, 2, 3, 6};
        int max = maxHistogramArea.getMaxArea(a);
        System.out.println("max = " + max);
    }

    private int getMaxArea(int[] a) {
        System.out.println("MaxHistogramArea.getMaxArea");
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        for (i = 0; i < a.length; i++) {
            int i1 = a[i];
            if(stack.empty() || a[stack.peek()] <= i1) {
                stack.push(i);
            } else {
                int temp = stack.pop();
                int new_area = 0;
                if(stack.empty()) {
                    new_area = a[temp]*i;
                } else {
                    new_area = a[temp] * (i - stack.peek() - 1);
                }
                max = max < new_area ? new_area : max;
                i--;
            }
        }
        while(!stack.empty()) {
            int temp = stack.pop();
            int new_area = 0;
            if(stack.empty()) {
                new_area = a[temp] * i;
            } else {
                new_area = a[temp] * (i - stack.peek() - 1);
            }
            max = max < new_area ? new_area : max;
        }
        return max;
    }
}
