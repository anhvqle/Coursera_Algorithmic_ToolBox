import java.util.*;

public class FibonacciSumSquares {
	
	/*
    f0^2 + f1^2 + f2^2+…….+fn^2
    = f0^2 + (f1f2– f0f1)+(f2f3 – f1f2 ) + ... + (fnfn+1 – fn-1fn )
    = fn(fn+1) (Since f0 = 0)
    */
	
	private static long getFibonacciLastDigit(long n) {
    	long[] Fib = new long[(int)n+1];
    	if(n <= 0) return n;
    	Fib[0] = 0;
        Fib[1] = 1;
        if(n>=2) {
        	for (int i = 2; i<=n;i++) {
        		Fib[i] = (Fib[i-1] + Fib[i-2])%10;
        	}
        }
        //System.out.println(Arrays.toString(Fib));
        return Fib[(int)n];
    }
    
    private static long getFibonacciSumSquares(long n) {
    	return (getFibonacciLastDigit(n%60)*getFibonacciLastDigit((n+1)%60)%10);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        long ans = getFibonacciSumSquares(n);
        System.out.println(ans);
    }
}

