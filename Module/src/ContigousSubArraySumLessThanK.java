import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by achaurasia on 11/11/16.
 */
public class ContigousSubArraySumLessThanK {
    public static void main(String[] args) {
        ContigousSubArraySumLessThanK contigousSubArraySumLessThanK = new ContigousSubArraySumLessThanK();
        int a[] = {10, 2, -3, 1, 2, 4, 1, 2, 4};
        ArrayList<Integer> res = contigousSubArraySumLessThanK.getWindow(a, 7);
        for (Iterator<Integer> iterator = res.iterator(); iterator.hasNext(); ) {
            Integer next =  iterator.next();
            System.out.println("next = " + next);
        }
    }

    ArrayList<Integer> getWindow(int a[], int k) {
        int maxStart = 0;
        int maxEnd = -1;
        int start = 0;
        ArrayList<Integer> result = new ArrayList<>();
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
        for (int i = maxStart; i <= maxEnd; i++) {
            result.add(a[i]);
        }
        return result;
    }
}
