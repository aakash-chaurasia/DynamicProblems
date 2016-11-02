import java.util.Scanner;

/**
 * Created by achaurasia on 10/31/16.
 */
public class CoinChangeProblem {
    public static void main(String[] args) {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem();
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int n = sc.nextInt();
        int coins[] = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int minCoins = coinChangeProblem.getMinCoins(sum, coins);
        System.out.println("minCoins = " + minCoins);
    }

    private int getMinCoins(int sum, int[] coins) {
        int[] minSum = new int[sum + 1];
        for (int i = 0; i < sum + 1; i++) {
            minSum[i] = sum + 1;
        }
        minSum[0] = 0;
        for (int i = 1; i < sum + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i && minSum[i - coins[j]] + 1  < minSum[i]) {
                    minSum[i] = minSum[i - coins[j]] + 1;
                }
            }
        }
        return minSum[sum];
    }
}
