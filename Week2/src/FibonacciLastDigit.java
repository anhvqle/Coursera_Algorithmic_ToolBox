import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigit(int n) {
    	if (n <= 0) return n;
    	int[] Fib = new int[n+1];
    	Fib[0] = 0;
        Fib[1] = 1;
        if(n>=2) {
        	for (int i = 2; i<=n;i++) {
        		Fib[i] = (Fib[i-1] + Fib[i-2])%10;
        	}
        }
        //System.out.println(Arrays.toString(Fib));
        return Fib[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        int ans = getFibonacciLastDigit(n);
        System.out.println(ans);
    }
}

