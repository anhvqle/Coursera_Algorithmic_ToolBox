import java.util.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	int numRefill = 0;
    	int currentRefill = 0;
    	while(currentRefill < stops.length) {
    		
    		int lastRefill = currentRefill;
    		while (currentRefill < stops.length && (stops[currentRefill+1] - stops[lastRefill] <= tank)) {
    			currentRefill = currentRefill + 1;
    			if(currentRefill == (stops.length - 1))
                    break;
    			//System.out.println("Last Refill: " + lastRefill + "\tCurrent Refill: " + currentRefill);
    		}
    		
    		if(currentRefill == lastRefill)
    			return -1;
    		
    		if(stops[lastRefill] + tank >= dist) return numRefill;
    		
    		if(currentRefill < stops.length)
    			numRefill += 1;
    	}
    	
        return numRefill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n+2];
        stops[0] = 0;
        for (int i = 1; i < n+1; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[stops.length-1] = dist;
        scanner.close();
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
/*
10
3
4 
1 2 5 9

950
400
4
200 375 550 750

200
250
2
100
150
 */