import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        TreeMap<Double, Integer > valueToWeightToWeight = new TreeMap<Double, Integer>(Collections.reverseOrder());
        for (int i = 0; i<weights.length; i++) {
        	valueToWeightToWeight.put(((double)values[i]/weights[i]), weights[i]);
        }
        for(Double i: valueToWeightToWeight.keySet()) {
        	if(valueToWeightToWeight.get(i) < capacity) {
        		value += valueToWeightToWeight.get(i)*i;
        		capacity -= valueToWeightToWeight.get(i);
        	}
        	else {
        		value += i*capacity;
        		break;
        	}
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.printf("%.4f", getOptimalValue(capacity, values, weights));
    }
} 
/*
3 50
60 20
100 50 
120 30

1 10
500 30
*/
