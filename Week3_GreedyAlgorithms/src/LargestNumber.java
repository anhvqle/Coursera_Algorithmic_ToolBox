import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
    	Arrays.sort(a, new StringComparator());
        StringBuilder result = new StringBuilder();
        for (String s : a) {
            result.append(s);
        }
        return result.toString();
    }
		
    private static class StringComparator implements Comparator<String> {
    	@Override
    	public int compare(String a, String b) {
    		a += b;
    		b += a;
    		for (int i = 0; i < a.length(); i++) {
    			if(a.charAt(i) > b.charAt(i)) 
    				return -1;
    			else if (a.charAt(i) < b.charAt(i)) 
    				return 1;
    		}
    		return 0;
    	}
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        scanner.close();
        System.out.println(largestNumber(a));
    }
}
/*
2
21 2

5 
9 4 6 1 9

3
23 39 92
 */

