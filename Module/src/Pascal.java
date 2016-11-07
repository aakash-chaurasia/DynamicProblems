import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Aakash on 11/7/2016.
 */
public class Pascal {
    public ArrayList<ArrayList<Integer>> generateDP(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int dp[][] = new int[a][a];
        for (int i = 0; i < a; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                temp.add(dp[i][j]);
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        Pascal pascal = new Pascal();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> result = pascal.generateDP(n);
        for (Iterator<ArrayList<Integer>> iterator = result.iterator(); iterator.hasNext(); ) {
            ArrayList<Integer> next =  iterator.next();
            for (Iterator<Integer> integerIterator = next.iterator(); integerIterator.hasNext(); ) {
                Integer integer =  integerIterator.next();
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
