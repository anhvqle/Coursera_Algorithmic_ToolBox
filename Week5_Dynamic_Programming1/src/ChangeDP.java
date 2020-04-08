import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money) {
        int[] minCoins = new int[money+1];
        int[] coins = {1,3,4};
        minCoins[0] = 0;
        for(int i = 1; i <= money; i++) {
        	minCoins[i] = Integer.MAX_VALUE;
        	for(int j = 0; j<coins.length; j++) {
        		if(i >= coins[j]) {
        			int numCoins = minCoins[i - coins[j]] + 1;
        			minCoins[i] = Math.min(minCoins[i], numCoins);
        		}
        	}
        }
        return minCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.close();
        System.out.println(getChange(m));
    }
}

/*
2  - output: 2
34 - output: 9
34 = 3 + 3 + 4 + 4 + 4 + 4 + 4 + 4 + 4.
 */
