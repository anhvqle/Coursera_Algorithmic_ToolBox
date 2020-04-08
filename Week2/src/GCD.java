import java.util.*;

public class GCD {
  private static long gcd(long a, long b) {
	  
	  /*
	  if(a == 0) return b;
	  else if (b == 0) return a;
	  else if(a > b) return gcd(a % b, b);
	  else return gcd(a, b % a);
	  }
	   */

	  if (b == 0) return a;
	  else if (a == 0) return b;
	  else {
		  if (a>b) return gcd(b, a%b);
		  else return gcd(a, b%a);
	  } 

  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();
    scanner.close();
    
    System.out.println(gcd(a, b));
  }
}
