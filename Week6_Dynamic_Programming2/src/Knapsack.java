import java.util.*;

public class Knapsack {
    static int optimalWeight(int maxWeight, int[] weights) {
        int n = weights.length;
        int[][] solution = new int[n + 1][maxWeight+1];
        
        for (int i = 0; i<= n; i++) {
        	for(int j = 0; j<= maxWeight; j++) {
        		if (i == 0 || maxWeight == 0)
                    solution[i][j] = 0;
        		else if (weights[i - 1] <= j)
                    solution[i][j] = Math.max(weights[i - 1] + solution[i - 1][j - weights[i - 1]], solution[i - 1][j]);
                else 
                    solution[i][j] = solution[i - 1][j];
        	}
        }
//        for(int i = 0; i< solution.length; i++) {
//        	System.out.println(Arrays.toString(solution[i]));
//        }
        
        return solution[n][maxWeight];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxWeight, numBars;
        maxWeight = scanner.nextInt();
        numBars = scanner.nextInt();
        int[] weights = new int[numBars];
        for (int i = 0; i < numBars; i++) {
        	weights[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(optimalWeight(maxWeight, weights));
    }
}

/*
10 3
1 4 8
 */
