import java.util.*;

public class FibonacciPartialSum {
	
	private static long getFibonacciLastDigit(long n) {
    	long[] Fib = new long[(int)n+1];
    	if(n <= 1) return n;
    	Fib[0] = 0;
        Fib[1] = 1;
        if(n>=2) {
        	for (int i = 2; i<=n;i++) {
        		Fib[i] = (Fib[i-1] + Fib[i-2])%10;
        	}
        }
        return Fib[(int)n];
    }
	/*-----------------------------------------------------*/
	private static long getFibonacciSum(long n) {
    	long pisano = 60; //pisano is 60 when module is 10
    	n = (n+2)%pisano; //sum(n) = Fib(n+2) - 1    	
    	
        if (n<=0) return n;
        long[] Fib = new long[(int)(n+1)];
        Fib[0] = 0;
        Fib[1] = 1;
        
        // Get the last digits of every Fibonacci
        for (int i = 2; i<=n; i++) {
        	Fib[i] = (Fib[i-1]+Fib[i-2])%10;
        }
        
        if(Fib[(int)n] == 0){
            return 9;
        }
        return (Fib[(int)n]%10-1);
	}
    /*-----------------------------------------------------*/
    
	private static long getFibonacciPartialSumFast(long from, long  to) {
    	long SumFrom, SumTo;
    	if (from == to) return getFibonacciLastDigit(from%60);    	
    	else {
    		from %= 60;
    		to %= 60;
    		SumFrom = getFibonacciSum(from - 1);
    		SumTo = getFibonacciSum(to);
    	}
    	long ans = (SumTo - SumFrom)%10;
    	return (ans>=0) ? ans : ans + 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        scanner.close();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}

