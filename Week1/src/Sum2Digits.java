import java.util.*;

public class Sum2Digits {

	public static void main(String[] args) {
		//System.out.println("Please enter 2 integers to generate the sum: ");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		input.close();
		System.out.println(a+b);
	}
}
