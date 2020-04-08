import java.util.*;

public class FibonacciSumLastDigits {
//	private static long Pisano_Length(long m) {
//        long Fib1 = 0, Fib2 = 1, F = Fib1 + Fib2, length = 0;
//        for (int i = 0; i < m * m; i++) {
//            F = (Fib1 + Fib2) % m;
//            Fib1 = Fib2; //move to the next 2 fibonacci numbers
//            Fib2 = F;
//            if (Fib1 == 0 && Fib2 == 1) /* The sequence starts at 0 and 1 again */  {
//                length = i + 1;
//                break;
//            }
//        }
//        return length;
//    }
	
    private static long getFibonacciSum(long n) {
    	long pisano = 60; //Pisano_Length(10); //pisano is 60 when module is 10
    	n = (n+2)%pisano; //sum(n) = Fib(n+2) - 1    	
    	
    	long[] Fib = new long[(int)(n+1)];
    	
        if (n<=0) return n;
        
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
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        
        long ans = getFibonacciSum(n);
        System.out.println(ans);
    }
}

