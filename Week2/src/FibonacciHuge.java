import java.util.*;

public class FibonacciHuge {
	
	private static long Pisano_Length(long m) {
        long Fib1 = 0, Fib2 = 1, F = Fib1 + Fib2, length = 0;
        
        for (int i = 0; i < m * m; i++) { //There are only m^2 possibilities for two consecutive digits
            F = (Fib1 + Fib2) % m;
            Fib1 = Fib2; //move to the next 2 fibonacci numbers
            Fib2 = F;
            if (Fib1 == 0 && Fib2 == 1) /* The sequence starts at 0 and 1 again */  {
                length = i + 1;
                break;
            }
        }
        return length;
    }
	
    private static long getFibonacciHuge(long n, long m) {
    	n = n%Pisano_Length(m);
        if (n <= 0)
            return n;
        long[] Fib = new long[(int)(n+1)];
        Fib[0] = 0;
        Fib[1] = 1;
        for (int i = 2; i<= n; i++) {
        	Fib[i] = (Fib[i-1] + Fib[i-2])%m;
        }
        return Fib[(int) n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        scanner.close();
        
        System.out.println(getFibonacciHuge(n, m));
    }
}

