import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {   
    	int ans = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: a) {
        	if(!map.containsKey(i))
        		map.put(i, 1);
        	else
        		map.put(i, map.get(i)+1);
        }
        for (int value: map.values()) {
        	if(value > a.length/2) {
        		ans = 1;
        		break;
        	}
        	else
        		ans = 0;
        }
        return ans;
        
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a, 0, a.length));
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

/*
10
512766168 717383758 5 126144732 5 573799007 5 5 5 405079772

5
2 3 9 2 2
 
4
1 2 3 4
 
4
1 2 3 1
*/