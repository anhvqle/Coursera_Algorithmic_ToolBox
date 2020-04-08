//import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();
    
    int[] Fib = new int[n+1];
    if (n<=0) {
    	System.out.println(n);
    	System.exit(0);
    }
    Fib[0] = 0;
    Fib[1] = 1;
    if(n >= 2) {
    	for(int i = 2; i<=n; i++) {
        	Fib[i] = Fib[i-1] + Fib[i-2];
        }  
    }
    System.out.println(Fib[n]);
    //System.out.println(Arrays.toString(Fib));
  }
}
