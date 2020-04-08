import java.util.*;

public class LCM {
	private static long gcd(long a, long b) {
		  if (b == 0) return a;
		  else if (a == 0) return b;
		  else {
			  if (a>b) return gcd(b, a%b);
			  else return gcd(a, b%a);
		  } 
	  }
  
  private static long lcm(long a, long b) {
	  return (a*b)/gcd(a,b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    scanner.close();

    System.out.println(lcm(a, b));
  }
}
